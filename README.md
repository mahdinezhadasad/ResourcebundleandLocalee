# Java Localization and Formatting Examples

This project demonstrates various Java functionalities for formatting, parsing, and localization using classes like `ResourceBundle`, `Locale`, and other tools for handling internationalization (i18n) and localization (L10n) in Java.

## Table of Contents
- [Overview](#overview)
- [Classes and Features](#classes-and-features)
  - [B05_Formatieren](#b05_formatieren)
  - [B06_ResourceBundle](#b06_resourcebundle)
  - [B07_ResourceBundle_API](#b07_resourcebundle_api)
  - [B08_ResourceBundle_KombinierenDerRessourcen](#b08_resourcebundle_kombinierenderressourcen)
  - [B09_ResourceBundle_Quellen](#b09_resourcebundle_quellen)
  - [Praktik](#praktik)
  - [TestRessourcenKombinieren](#testressourcenkombinieren)
  - [TestStringsSuchen](#teststringssuchen)
- [Getting Started](#getting-started)
- [License](#license)

## Overview

This project is designed to illustrate how to work with localization and formatting in Java. By leveraging classes like `ResourceBundle`, `Locale`, and `DateTimeFormatter`, the examples demonstrate parsing, formatting, and locale-sensitive data retrieval to help you build applications that can easily adapt to different languages and regions.

## Classes and Features

### B05_Formatieren

This class demonstrates **number formatting and parsing** as well as **date formatting**. The `bspMitNumberFormat` method shows how to:
- Format a number into a currency string using the default and specific locales.
- Parse a formatted currency string back into a `Number` object.

The `bspMitDateTimeFormatter` method shows:
- How to format dates according to the locale, displaying the day name in various formats (`E`, `EEEE`, `EEEEE`) for different languages.

### B06_ResourceBundle

This class illustrates how to use `ResourceBundle` to load localized resources. Key concepts covered include:
- Using a default resource file (e.g., `app.properties`) and language-specific resource files (e.g., `app_de.properties` for German).
- Automatically adjusting application content based on system language settings.

### B07_ResourceBundle_API

This class provides an in-depth look at the `ResourceBundle` API. It shows:
- How to load resources using both the default and a specific locale.
- How `ResourceBundle` selects the appropriate file based on locale (e.g., `app_de.properties` or `app.properties`).
- How to retrieve strings and objects from resource files.

### B08_ResourceBundle_KombinierenDerRessourcen

This class explores **resource combination** in `ResourceBundle`. Topics include:
- How `ResourceBundle` generates candidate names for resource files based on the base name and locale.
- How it attempts to locate the most specific resource available for the given locale.
- An example that uses `de_DE` as the default locale and shows how `getString` searches through different resources.

### B09_ResourceBundle_Quellen

This class explains the two main sources for `ResourceBundle` data: `.properties` files and Java classes. Key points include:
- How to use Java classes that extend `ListResourceBundle` as a source for `ResourceBundle`.
- The need to override `Object[][] getContents()` in a class when using it as a resource.

### Praktik

This class displays **all available locales** in a formatted table. Key features:
- Retrieves and sorts locales by display country, display language, and other attributes.
- Dynamically calculates column widths to fit the longest values.
- Uses helper methods to safely retrieve ISO3 country and language codes.

### TestRessourcenKombinieren

This class contains methods to test **resource combination** with various locales. Each test demonstrates how `ResourceBundle` attempts to load the most specific resource files based on the locale. Examples include:
- Setting different default locales (`de_DE`, `fr_FR`, etc.).
- Verifying how `ResourceBundle` handles resource file fallbacks when specific files are unavailable.

### TestStringsSuchen

This class tests searching for keys within resource files using `ResourceBundle`. It demonstrates:
- How to retrieve specific properties using `getString`.
- Error handling with `MissingResourceException` when a key is missing.
- Setting a default locale to control the results of the resource search.

## Getting Started

To run this project:
1. Clone the repository.
   ```bash
   git clone https://github.com/yourusername/JavaLocalizationExamples.git
