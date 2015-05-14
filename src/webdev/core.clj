(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]))

(defn greet
  "A function to process all requests for the web server"
  [request]
  {:status 200
   :body "Hello, Clojure World"
   :headers {}})

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty greet
     {:port (Integer. port-number)}))

