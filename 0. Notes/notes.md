# Accessor Methods

In Unit 5 Section 1, we discussed how both class and instance variables are almost always kept `private` to maintain the security of the values. We also mentioned that we can offer a user access to the information by way of **accessor methods** despite the `private` nature of variables. This section dives into what accessor methods are and do.

---

## Method Information

Since accessor methods are **methods**, we need to generally understand methods in order to understand accessor methods. Here is a general header for a method that helps us to see the components:

```java
public/private type methodName(parameter1type parameter1, parameter2type parameter2, etc.) {
    // Not shown.
}
```

In this header, we have a few components, which we can break down:
- `public/private` --> Each method can be assigned either `public` or `private` (never both), indicating how accessible it is. Accessor methods will always be `public`.
- `type` --> This is where we designate **`return` type**, essentially preemptively stating what kind of information the method is going to send back when it is done, if any. This can be any of our data types like `int`, `double`, `boolean`, or `String`, or it can send no information back, in which case we write the keyword `void` in that spot. Accessor methods will have a return type that is the same as the variable it represents (if it is an `int` variable, it will send back an `int` value, etc.).
- `methodName` --> This is the nickname to refer to this method by (like `substring`). The general rule for accessor methods, since they **get** information, is to call them `getVariableName`, so if the variable was `age`, we would call it `getAge`.
- `(parameter1type parameter1, parameter2type parameter2, etc.)` --> Inside the parentheses, we have the **parameter list**. This is how a user sends information for the method to use (kind of like when you send a starting and ending index for `substring`). You are essentially declaring variables for this, so each needs a data type and a nickname to be referred to as, and would be separated by commas. You can have zero, one, or many parameters, as many as you need. Accessor methods don't need parameters because they are just sending back information that already exists, so they would have empty parentheses `()`.

After the keyword `return` is used in a method, the control flow of the program shifts back to wherever the method was called, immediately ending the method.

---

## Accessor Methods

By definition, an accessor method allows other objects to obtain the value of instance or class variables. Here is an example of a couple of accessor methods from the `Person.java` file:

```java
public String getName() {
    return name;
}

public int getAge() {
    return age;
}
```

Accessor methods are really simple to write, as all they do is `return` the value of the variable in question, so that someone can access the information externally. Notice that these two accessor methods follow all the pieces described above: they are `public`, have the `return` types `String` and `int` respectively, have a name of the form `getVariableName`, and have empty parentheses. Because they have `return` types that are not `void`, they should have the keyword `return` used at some point to send information back, which we see in the form of `return name` and `return age` respectively.

---

## Return by Value

An important minute detail about the `return` keyword is how it communicates information. Java methods follow a rule known as **`return` by value**, so when you use the keyword `return`, it specifically makes a copy of the information, and sends that to the user, meaning they never actually have access to the memory location of the thing being returned.

---

## `toString` Methods

Sometimes, we try to print out an object made from a class, like this example from the `NotesToString1.java` file:

```java
Person person1 = new Person("Mr. G", 25);
System.out.println(person1);
```

How does Java decide what to print out for that? By default, Java calls the **`toString` method**, which would communicate how to turn a whole object into a temporary `String`. The problem is that not all classes have a `toString` method, but this still happens regardless. All objects have an unwritten `toString` method that will provide the object's class and memory location as a `String` to print out, resulting in this kind of output for our code above:

```
Person@2f92e0f4
```

To us as programmers, this isn't really helpful, as it doesn't tell us anything about the object, when we know it stores information like a `name` and an `age`. Fortunately, we can write our own `toString` method in the `Person` class that will **override** (this is a technical term) the generic `toString` method that doesn't help us. The header for a `toString` class will always look like this:

```java
public String toString() {
    // Not shown.
}
```

Because it uses the exact same name as the generic `toString` method, it overrides it, and the print statement will call this one automatically instead. Note that it has a `return` type of `String`, because we expect it to make us a `String` that describes the object. Here is an example of a `toString` method for the `Person` class from the `Person.java` file:

```java
public String toString() {
    return name + " is " + age + " years old.";
}
```

Note that this `toString` method has exactly the same header as our sample above, it has to in order to work! There is no right or wrong way to "make a `String` that describes an object", sometimes less information is better. You don't necessarily have to use every instance variable, but we always try to make sure it provides enough information to identify the object reasonably well. With this in place in the `Person` class, we can re-run the code from the `NotesToString1.java` file and see that the output is now different:

```
Mr. G is 25 years old.
```

This output is much more useful and seems to actually tell me something about the object that I was printing. Here is an example from the `NotesToString2.java` file:

```java
Person person1 = new Person("Mr. G", 25);
Person person2 = new Person();

System.out.println(person1);
System.out.println(person2);
```

Without our custom `toString` method, this would be what the output looks like:

```
Person@2f92e0f4
Person@28a418fc
```

It is impossible to tell from this output which `Person` is which. With our `toString` method though, it is immediately apparent:

```
Mr. G is 25 years old.
 is -1 years old.
```

You can call an object's `toString` method manually anytime you want. At the same time though, anytime an object is asked to turn into a `String` (printing, concatenating an object with another `String`, etc.), it calls this automatically so you don't have to write it.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
