# How to implement a concept exercise

This document describes the steps required to implement a concept
exercise in for the common-lisp track. In this document the
placeholder `<SLUG>` refers to the name of the exercise in kebab-case.

Before implementing the exercise, please make sure you have a good
understanding of what the exercise should be teaching (and what not).
This information can be found in the exercise's GitHub issue.

Any concept exercise in the common-lisp track requires the following files to
be created:

<pre>
languages
└── common-lisp
    └── exercises
        └── concept
            └── &lt;SLUG&gt;
                ├── .docs
                |   ├── instructions.md
                |   ├── introduction.md
                |   ├── hints.md
                |   └── after.md (optional)
                └── .meta
                    └── config.json
                └──  &lt;SLUG&gt;.lisp
                └──  &lt;SLUG&gt;-test.lisp
                └──  &lt;SLUG&gt;.asd
                └──  package.lisp
</pre>

## Step 1: add track specific files

Exercise code should be clean, clear and "exemplary". It should not be
*clever*. The testing library for this track shall be
[FiveAm][fiveam]

Each file listed below links to an example file which can be used as a
stub. 

* [`<SLUG>`.asd](examples/exercise-stubs/slug.asd)

    This is an ASDF system definition which should define two systems:
    `"<SLUG>"` and `"<SLUG>/test"`. The `test-op` of `"<SLUG>"` should
    call the `load-op` of "<SLUG>/test" which will in turn load and
    run the tests.
    
    The system `"<SLUG>"` should have no dependencies.
    
    The system `"<SLUG>/test"` should depend upon `"<SLUG>"` and
    `fiveam`. 
    
* [package.lisp](examples/exercise-stubs/package.lisp)

    This file should define two packages using `defpackage`:
    `#:<SLUG>` and `#:<SLUG>-test`.
    
    Package `<SLUG>` should export the public methods that are used in
    the tests. It should `:use` only `:common-lisp`.
    
    Package `<SLUG>-test` should export a function `run-all` which
    will run all the tests. It should `:use` only `:common-lisp`,
    `:<SLUG>` and `:fiveam`.

* [`<SLUG>`-test.lisp](examples/exercise-stubs/slug-test.lisp)

    This file will start with `(in-package :<SLUG>-test)`.
    
    It will contain tests for this exercise.
    
    It should have a function `run-all` which will run all the tests
    defined here. (This function will be called from the `test-op` of
    the system.)

* [`<SLUG>`.lisp](examples/exercise-stubs/slug.lisp)

    This file will start with `(in-package :<SLUG>)`.
    
    It should contain any stub functions or variables appropriate to
    this exercise.
    
    Variables should generally be bound to `nil` and functions should
    generally evaluate to `nil` unless it would be more instructional
    for them not to be.
    
    It is suggested that documentation strings be provided for all
    stubs defined in this file.

## Step 2: add common files

Please refer to the [how to implement a concept exercise
document][how-to-implement-concept-exercise] for information on the
common files all tracks need.

## Inspiration

When implementing an exercise, it can be very useful to look at the
exercises the track has already implemented. You can also check the
exercise's [general concepts documents][reference] to see if other
languages that have already an exercise for that concept.

## Help

If you have any questions regarding implementing this exercise, please
post them as comments in the exercise's GitHub issue.

[how-to-implement-concept-exercise]: ../../../docs/maintainers/generic-how-to-implement-a-concept-exercise.md
[fiveam]: https://github.com/sionescu/fiveam
[reference]: ../../../reference/concepts/README.md

