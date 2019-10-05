package apps.webbrowser

import javafx.application.Application
import javafx.beans.property.SimpleStringProperty
import javafx.scene.web.WebView
import tornadofx.*
import tornadofx.Stylesheet.Companion.webView

fun main(args: Array<String>) {
    Application.launch(WebBrowserApp::class.java)
}

class WebBrowserApp : App(WebBrowser::class)


class BrowserViewModel(initialAddress: String) : ViewModel() {
    val url = bind { SimpleStringProperty(initialAddress) }
}

class WebBrowser : View("Browser") {
    lateinit var webView: WebView
    val viewModel = BrowserViewModel("http://www.google.com")
    override val root = gridpane {
        row {
            hbox {
                button("Back") {
                    action {
                        webView.engine.executeScript("history.back()")
                    }
                }
                button("Forward") {
                    action {
                        webView.engine.executeScript("history.forward()")

                    }
                }
                textfield {
                    textProperty().bindBidirectional(viewModel.url)
                }
                button("Go") {
                    action {
                        webView.engine.load(viewModel.url.value)
                    }
                }
            }
        }
        row {
            webView = webview {
                engine.load(viewModel.url.value)
            }
        }
    }
}