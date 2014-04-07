# Human-friendly Random Name Generator

This little library generates human friendly random identifiers. For example, given the following
code,

    RandomNameGenerator rnd = new RandomNameGenerator(0);

    for (int i=0; i<10; i++)
        System.out.println(rnd.next());

The output will be as follows:

    constructive_carrot
    flexible_designer
    linear_fund
    popular_leaf
    steady_parent
    abstract_rest
    controversial_supply
    fragrant_absorption
    lively_cassette
    powerful_destruction

In testing, these names are more useful than number-based random names, as they are more memorable to
humans.

The generator is based on a fixed dictionary of about 600 adjectives and 2400 nouns, thereby
producing little more than 1.5 million unique combinations. If you keep calling the `next()`
method beyond this limit, it'll start producing the same name again.

The generator is pseudo-random, meaning if you provide the same seed value, it'll always
generate the same sequence of identifiers.