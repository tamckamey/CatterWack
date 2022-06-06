# Catterwack

Catterwack is an Android application built inside of Android Studio using the language Kotlin.

## Introduction

Catterwack is a mobile application that allows users to generate a cat with a given age and gender based on the cat's name. To accomplish this, Catterwack takes advantage of web APIs such as [Agify.io](https://agify.io/) and [Genderize.io](https://genderize.io/). On top of receiving the information about the generated cat, the user is also provided a picture of their cat by utilizing [TheCatApi](https://docs.thecatapi.com/). Once the user has created a cat that they find particularly cute (or just funny), the user is provided the chance to save their cat to their phone to be viewed at anytime!

You never have to lose your precious kitties now!

## Imports
Catterwack utilizes many libraries that are made for the Kotlin language, but the following are the most notable:
1. **[Picasso](https://square.github.io/picasso/)**: An advanced library which handles image creation for developers. It also handles features like caching the images for the developer.
2. **[Room](https://developer.android.com/training/data-storage/room)**: A data persistence library that integrates with SQLite. One of the most popular local data saving solutions for Android Studio.
3. **[Retrofit](https://square.github.io/retrofit/)**: A type-safe HTTP client for Android development. This is one of the most popular methods for accessing web data for Android applications

## Usage
Once the user has opened the Catterwack app, they will be able to select to "Create" or "Load" a cat.
1. **Creating a Cat**: Creating a cat in Catterwack is extremely simple. Just make sure that you're connected to the internet, and then open the "Create A Cat" page. From this page, simply type in your chosen name and click the "Meow" button! At this point, you'll be provided your new cat, and will have the ability to save it or return to the creation page!
2. **Load a Cat**: Loading a cat has never been this easy! Simply make sure that you're connected to the internet and click "Load a Cat," from this page you can use the arrow buttons to sort through all of your saved cats! Isn't that amazing?