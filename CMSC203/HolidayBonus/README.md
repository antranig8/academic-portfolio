# Holiday Bonus Calculator – CMSC203 Assignment 5

Java implementation of two backend utility classes used to process ragged 2D sales data
and compute store holiday bonuses. This project includes:

- `TwoDimRaggedArrayUtility` – a helper class for reading, writing, and analyzing ragged 2D arrays
- `HolidayBonus` – calculates bonuses for each store based on highest/lowest sales per category

The GUI for this assignment was provided by the instructor.

---

## **Features**

### **TwoDimRaggedArrayUtility**
Utility methods for ragged 2-dimensional arrays of doubles:
- Read sales data from a text file (`readFile`)
- Write a ragged array back to a text file (`writeToFile`)
- Calculate totals and averages
- Row and column totals, even when rows have different lengths
- Highest & lowest values in any row or column
- Highest & lowest values in the entire array

### **HolidayBonus**
Logic for computing holiday bonuses:
- Highest value in each category → **$5000**
- Lowest non-negative value in each category → **$1000**
- All other eligible stores → **$2000**
- Stores with zero or negative values receive **no bonus**
- Returns:
  - An array of bonuses per store
  - Total district bonus amount

---

## **src/**
- `TwoDimRaggedArrayUtility.java`
- `HolidayBonus.java`
- `HolidayBonusTestStudent.java`
- `TwoDimRaggedArrayUtilityTestStudent.java`
- `HolidayBonusGui.java`
---

## **resources/**
Included test datasets used for verifying calculations:
- `dataSet1.txt`
- `dataSet2.txt`
- `dataSet3.txt`
- `dataSet4.txt`
- `district3.txt`
- `district4.txt`
- `district5.txt`
- `newDistrict6.txt`
- `newDistrict7.txt`

---
## Download

A self-contained Windows build (no Java or JavaFX required) is available here:

[Download HolidayBonus for Windows](https://github.com/antranig8/academic-portfolio/releases/tag/cmsc203-holidaybonus-v1)

Each file contains:
- 4–6 rows
- Ragged columns (rows have different lengths)
- Positive, zero, and negative sales values to test all edge cases