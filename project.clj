(defproject manifold "0.1.0-SNAPSHOT"
  :description "a compatibility layer for event-driven abstractions"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/tools.logging "0.2.6"]]
  :profiles {:dev {:dependencies [[codox-md "0.2.0" :exclusions [org.clojure/clojure]]
                                  [org.clojure/clojure "1.5.1"]
                                  [criterium "0.4.3"]
                                  [org.clojure/core.async "0.1.267.0-0d7780-alpha"]]}}
  :test-selectors {:default #(not (some #{:benchmark :stress}
                                        (cons (:tag %) (keys %))))
                   :benchmark :benchmark
                   :stress #(or (:stress %) (= :stress (:tag %)))
                   :all (constantly true)}
  :plugins [[codox "0.6.4"]]
  :codox {:writer codox-md.writer/write-docs
          :include [manifold.deferred manifold.stream manifold.time]}
  :global-vars {*warn-on-reflection* true}
  :jvm-opts ["-server"])
