Welcome

This is written in Kotlin and Compose for UI and Hilt for DI
There are unit tests for the repository, viewDataMapper and viewModel

The ui should display the "What is the average property price?" question in the middle of the screen then when the answer is available it will show 10dp below that
The average price is only revealed after a button click at which point:

a loading spinner shows, 

a network request happens, if error then error shows ,

else dto is mapped to viewData ,

finally ViewData state changes to Data and is loaded with the viewData,

the average price is displayed

You will notice the screen is split into two columns to ensure the question is exactly in the middle of the screen, this is naff, should have done offsets, I just didn't get around to changing it at the end

Some components are designed to be inflexible so that they will always meet the design spec, e.g. TechText and TechButton

This way any usage will have the correct text size and colour

Similarly there is a SizeTokens object so that if padding wanted to be changed across the app e.g. all columns now have 15 padding then medium token could be updated

Error is handled in the screen, this is a decision to keep the project size down, and allow time for more testing.

There is a CallAdapter which handles errors in the Api call

Classes such as Repository and Api are named just Repository and Api to make it very clear what they do, obviously in a larger project naming would be more specific

PropertyListViewData hides does not contain door numbers so that users cannot see the exact location of a property until revealed by an agent/vendor
I am mapping more of the Dto to ViewData so that we can do more with it in an interview

The propertyType is an enum in the viewData because I think it is a discreet type although I have handled an unknown type. 

A challenge would be if a new class of home became available to render it correctly we would need a native release.

However by having a defined set of types users can search by type from a predefined drop down.

I also believe the chance of new types of property becoming available could probably be seen coming e.g. there would probably be need to be a business decision to begin listing Tiny Homes or RVs

Hopefully that would be signalled far enough in advance that we can add types to this enum before there is a chance of there being an issue.

There are some extra screens such as error screen and dummy screen which are not used as no navigation is needed, however maybe we can do that during an interview?

There are many additional comments in the code to help with understanding
