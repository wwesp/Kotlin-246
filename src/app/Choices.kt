package app

import javafx.*
import view.MainView
import tornadofx.App
import view.Choice0View

class choice0: App(Choice0View::class, Styles::class)

class MyApp: App(MainView::class)