# hp-api

This Android app is made with MVVM architecture. Retrofit is used for reading data from hp-api: https://hp-api.onrender.com. Glide for rendering 
profile pictures of harry potter characters. Main idea for the app is, using two fragments with one activity: One for listing the characters with a 
recyler-view and another to show the detailed character information when user taps on one of the characters in the list. View binding is used, and
information is passed between fragments via a shared Viewmodel.
