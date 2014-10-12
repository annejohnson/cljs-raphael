(defproject cljs-raphael "0.1.0-SNAPSHOT"
  :description "Clojurescript/Raphael funsies"
  :url "http://annejohnson.github.io/clojurescript-raphael"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2173"]]
  :plugins [[lein-cljsbuild "1.0.2"]]
  :cljsbuild {
    :builds [{
        :source-paths ["src/cljs_raphael"]
        :compiler {
          :output-to "resources/js/app.js"
          :optimizations :whitespace
          :pretty-print true}}]})
