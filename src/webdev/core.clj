(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn greet
  "A function to process all requests for the web server.  The default route / returns one message, /goodbye route another. for all other routes an error message is returned"
  [request]
  (cond
   (= "/" (:uri request))
   {:status 200
    :body "Hello, Clojure World.  I now update automatically"
    :headers {}}
   (= "/goodbye" (:uri request))
   {:status 200
    :body "This is the end, my old friend"
    :headers {}}
   :else
   {:status 404
    :body "Sorry, page not found"
    :headers {}}))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty greet
     {:port (Integer. port-number)}))

(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'greet)
     {:port (Integer. port-number)}))

