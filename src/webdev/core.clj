(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty
     (fn [request] {:status 200
                   :body "Hello, Clojure World"
                   :headers {}})
     {:port (Integer. port-number)}))

