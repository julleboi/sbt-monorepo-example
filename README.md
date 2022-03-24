# sbt monorepo example

This example has 3 subprojects:
- common
- foo
- bar

Each of them has their own dependencies + shared dependencies.

GitHub actions trigger tests for only that subproject.

No need to store common-jar as it's included in each subproject.

All projects can share package versions / scala versions / compiler options etc.
