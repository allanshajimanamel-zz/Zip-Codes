# README #

This is a technical code assignment for a company.

The code has been written from scratch. I have used Eclipse IDE and created a simple JAVA project. The class com.allan.zipcodes.ZipCodesIntervalUnion has a main method which can be utilized to run the code.

The same project with dependencies managed through maven can be found at https://bitbucket.org/allanmanamel/zip-codes-interval/overview

### What is this repository for? ###

* Quick summary of problem

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

SOLUTION
The algorith used for the implementation is 
```
define merge(intervals): // intervals is list of interval pairs
if intervals is empty then
	return empty list;
if intervals.size == 1 then
	return intervals;
result = empty list; 
sort(intervals, LowerBasedComparator)
previous = intervals[0];
for i = 1 to n-1 //n is the size of intervals list
   current = intervals[i];
   if current.lower < previous.upper then
      previous = new Interval(previous.lower, max(current.upper, previous.upper));
   else
      result.add(previous);
      previous = current;
    end
end loop;
result.add(previous)
return result;
```
This algorithm runs in O(nlgn) time and is implemented in my class com.allan.zipcodes.ZipCodesIntervalUnion

* Version
1.0.0

### Who do I talk to? ###

* Repo owner: Allan Shaji Manamel
* Email     : allanshajimanamel@gmail.com
