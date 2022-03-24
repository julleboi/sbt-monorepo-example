# sbt monorepo example

This example has 3 subprojects:
- common
- foo
- bar

**Each of them has their own dependencies + shared dependencies.**

**GitHub actions trigger tests for only that subproject. (changes to common triggers all tests)**

**No need to store common-jar as it's included in each subproject.**

**All projects can share package versions / scala versions / compiler options etc.**

### Some links

- https://www.scala-sbt.org/1.x/docs/Multi-Project.html
- https://stackoverflow.com/a/46160521
- https://alexklibisz.com/2021/01/31/sane-scala-sbt-dependencies.html (polyrepos)
