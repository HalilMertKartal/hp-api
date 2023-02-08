# hp-api

This Android app is made with MVVM architecture. Retrofit is used for reading data from hp-api: https://hp-api.onrender.com, RXJava for asynchronous operations and Glide for rendering profile pictures of Harry Potter characters. Main idea for the app is, using two fragments with one activity: One for listing the characters with a recyler-view and another to show the detailed character information when user taps on one of the characters in the list. View binding is used as the binding strategy. Information is passed between fragments via a shared ViewModel.
