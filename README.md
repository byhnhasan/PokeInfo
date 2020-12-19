# PokeInfo

<p align="left">
<img src="/previews/screen_shot.png"/>
<img src="/previews/gif_one.gif"/>
<img src="/previews/gif_two.gif"/>
</p>


Pokeinfo is a small application based on latest Android tech stack and MVVM architecture.

#Tech Stack

-Asynchronous -> Kotlin Coroutines + Flow
-Dependency Injection -> Hilt(alpha)
-UI -> LiveData, Lifecycle, ViewModel
-Architecture -> MVVM(Model -> DataBinding -> View -> ViewModel), Repository pattern
-Network -> Retrofit2, OkHttp3

## Open API

<img src="https://user-images.githubusercontent.com/24237865/83422649-d1b1d980-a464-11ea-8c91-a24fdf89cd6b.png" align="right" width="21%"/>

Pokeinfo using the [PokeAPI](https://pokeapi.co/) for constructing RESTful API.<br>
PokeAPI provides a RESTful API interface to highly detailed objects built from thousands of lines of data related to Pokémon.
