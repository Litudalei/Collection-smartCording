# Collection-smartCording
Customized Notes By Java Developer Gitiranjan Dalei
import java.util.LinkedList;

public class LinkedListIteration {
    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.add("Rahul");
        names.add("Amit");
        names.add("John");
        names.add("David");

        System.out.println(names);
    }
}
[Rahul, Amit, John, David]
Rahul
  ↓
Amit
  ↓
John
  ↓
David
  ↓
null
Each element is stored inside a node, and each node maintains a reference to the next node.

2. Iterating using a for loop

You can use the index-based for loop:

for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}
Output
Rahul
Amit
John
David
How it works
names.get(0);
names.get(1);
names.get(2);
names.get(3);

The loop repeatedly calls get(i).

⚠️ Important

For a LinkedList, this is generally not the preferred way to iterate.

Why?

LinkedList does not provide direct/random access like an array.

When you do:

names.get(3);

Java has to traverse nodes to reach that position.

Conceptually:

Head
 ↓
Rahul → Amit → John → David
                      ↑
                  get(3)

Therefore, repeatedly calling get(i) can make iteration inefficient.

For a linked list containing n elements, an index-based loop can result in approximately:

O(n²)

in the worst/general case.

3. Enhanced for-each loop ⭐

This is one of the easiest and preferred ways to iterate.

for (String name : names) {
    System.out.println(name);
}
Output
Rahul
Amit
John
David
What is happening?

When you write:

for (String name : names)

Java internally uses an Iterator for the collection.

Conceptually:

LinkedList
    ↓
Iterator
    ↓
Rahul
    ↓
Amit
    ↓
John
    ↓
David

This means you don't need to manually access:

get(0)
get(1)
get(2)
...

Instead, the iterator moves from node to node.

Complexity

For normal iteration:

Time:  O(n)
Space: O(1)

So for simply reading every element, this is much better than repeatedly using get(i).

4. Iterating using Iterator

You can explicitly create an Iterator.

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIteration {

    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.add("Rahul");
        names.add("Amit");
        names.add("John");
        names.add("David");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {

            String name = iterator.next();

            System.out.println(name);
        }
    }
}
Output
Rahul
Amit
John
David
Understanding Iterator

There are two important methods:

hasNext()

Checks whether another element exists.

iterator.hasNext()

Returns:

true

or

false
next()

Moves to the next element and returns it.

iterator.next()
Example

Suppose:

Rahul → Amit → John → David

Initially:

Iterator
   ↓
Rahul → Amit → John → David

Calling:

iterator.next();

returns:

Rahul

Then the iterator moves forward.

Rahul → Amit → John → David
         ↑
      Iterator

Next:

iterator.next();

returns:

Amit

And so on.

5. Why do we need hasNext()?

Consider:

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

The logic is:

Is another element available?
       ↓
      YES
       ↓
Get the element
       ↓
Move forward
       ↓
Is another element available?
       ↓
      YES
       ↓
     ...
       ↓
      NO
       ↓
     STOP

This prevents calling next() when there is no element left.

6. Removing elements while iterating

This is one of the most important reasons to understand Iterator.

Suppose we want to remove "John".

❌ Don't do this
for (String name : names) {

    if (name.equals("John")) {
        names.remove(name);
    }
}

This can result in:

ConcurrentModificationException

Instead, use the iterator's remove() method.

✅ Correct approach
Iterator<String> iterator = names.iterator();

while (iterator.hasNext()) {

    String name = iterator.next();

    if (name.equals("John")) {
        iterator.remove();
    }
}

Now "John" will be safely removed.

7. ListIterator

LinkedList also supports ListIterator.

ListIterator<String> iterator = names.listIterator();

while (iterator.hasNext()) {

    System.out.println(iterator.next());
}

Import:

import java.util.ListIterator;

The important difference is that ListIterator can move in both directions.

Forward
→ → → →

Backward
← ← ← ←
8. Forward iteration using ListIterator
ListIterator<String> iterator = names.listIterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

Output:

Rahul
Amit
John
David
9. Backward iteration using ListIterator

First move the iterator to the end:

ListIterator<String> iterator =
        names.listIterator(names.size());

Then:

while (iterator.hasPrevious()) {

    System.out.println(iterator.previous());
}

Output:

David
John
Amit
Rahul

This is a major advantage of ListIterator.

10. ListIterator methods

Some important methods are:

Method	Purpose
hasNext()	Checks whether next element exists
next()	Gets next element
hasPrevious()	Checks whether previous element exists
previous()	Gets previous element
remove()	Removes current element
add()	Adds an element
set()	Replaces current element
11. Using forEach()

Java 8 introduced the forEach() method.

names.forEach(name -> {
    System.out.println(name);
});

Or even shorter:

names.forEach(System.out::println);

Output:

Rahul
Amit
John
David

This is convenient when you simply want to perform an operation on every element.

12. Comparison of iteration techniques
Technique	LinkedList Performance	Can remove safely during iteration?	Forward	Backward
for + get(i)	❌ Poor for repeated access	❌	✅	❌
for-each	✅ Good	❌ directly	✅	❌
Iterator	⭐ Excellent	✅ iterator.remove()	✅	❌
ListIterator	⭐ Excellent	✅	✅	✅
forEach()	✅ Good	Limited	✅	❌
13. Most important concept

For a LinkedList, remember this:

❌ Avoid this for normal iteration
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

Because get(i) requires traversal.

✅ Prefer this
for (String value : list) {
    System.out.println(value);
}
✅ Or
Iterator<String> iterator = list.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
✅ If you need forward + backward traversal
ListIterator<String> iterator = list.listIterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
14. Deep understanding: LinkedList + Iterator

Suppose your list is:

        next       next       next
[A]  ───────> [B] ───────> [C] ───────> [D]

An index-based loop asks:

list.get(0)
list.get(1)
list.get(2)
list.get(3)

The list may need to traverse nodes to find each position.

An iterator instead maintains its traversal position:

Iterator
   ↓
[A] → [B] → [C] → [D]

After:

iterator.next();

it advances:

[A] → Iterator → [B] → [C] → [D]

Then:

iterator.next();

advances again:

[A] → [B] → Iterator → [C] → [D]

So the iterator naturally follows the linked structure.

🎯 Interview takeaway

If an interviewer asks:

How do you iterate over a LinkedList efficiently?

A good answer is:

"I would normally use an enhanced for-each loop or an Iterator. For a LinkedList, repeatedly using get(index) can be inefficient because accessing an index requires traversal. An Iterator traverses the list sequentially and provides O(n) iteration. If I need bidirectional traversal or insertion/removal during traversal, I can use ListIterator."

Remember this hierarchy
LinkedList
    │
    ├── for + get(i)       → Avoid for iteration
    │
    ├── for-each           → ⭐ Simple & preferred
    │
    ├── Iterator           → ⭐ Traversal + safe removal
    │
    ├── ListIterator       → ⭐ Forward + backward + modification
    │
    └── forEach()          → ⭐ Convenient Java 8+

Next important topic: understanding how Iterator actually works internally with LinkedList nodes, including next(), hasNext(), and remove() step-by-step.
