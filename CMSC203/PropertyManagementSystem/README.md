# Property Management System – CMSC203 Assignment 4

Java implementation of a simple property management backend using three classes: `Plot`, `Property`, and `ManagementCompany`.
The system validates plots, enforces capacity rules, and supports rent calculations for a fixed-size management company.

## Features
- `Plot` class for rectangular coordinates, width, and depth
- Overlap and encompass detection between plots
- `Property` class storing name, city, owner, rent, and plot
- `ManagementCompany` class holding up to 5 properties
- Validation for:
  - properties being inside the management plot
  - non-overlapping property plots
  - full/empty property list conditions
- Total rent calculation and highest-rent property lookup
- Formatted `toString()` output for properties and company summary
- Student-written JUnit tests for all three classes

## src/
- `Plot.java`
- `Property.java`
- `ManagementCompany.java`
- `PlotTestStudent.java`
- `PropertyTestStudent.java`
- `ManagementCompanyTestStudent.java`
- `PropertyMgmGUI.java`
### resoures/
Contains images used inside the GUI

---
## Download

A self-contained Windows build (no Java or JavaFX required) is available here:

[Download PropertyManagementSystem for Windows](https://github.com/antranig8/academic-portfolio/releases/tag/cmsc203-propertymgmt-v1)

## Notes
- GUI (`PropertyMgmGUI.java`) was provided by the instructor and not modified
- Management company plot has fixed size (width 10, depth 10)
- Maximum number of properties managed is 5
- Error codes from `addProperty` follow the assignment spec (−1 to −4 on failure)