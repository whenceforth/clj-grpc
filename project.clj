(defproject clj-grpc "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license
  {:name "Eclipse Public License"
   :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ^:skip-aot clj-grpc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}

  :plugins [[lein-protoc "0.4.2"]]

  :protoc-version "3.7.1"
  :protoc-grpc {:version "1.20.0"}
  :proto-target-path "target/generated-sources/protobuf"

  :java-source-paths
  ["target/generated-sources/protobuf"]

  :dependencies
  [[org.clojure/clojure "1.10.0"]
   [com.google.protobuf/protobuf-java "3.7.1"]
   [io.netty/netty-codec-http2 "4.1.25.Final"]
   [io.grpc/grpc-core "1.20.0"]
   [io.grpc/grpc-netty "1.20.0"
    :exclusions [io.grpc/grpc-core
                 io.netty/netty-codec-http2]]
   [io.grpc/grpc-protobuf "1.20.0"]
   [io.grpc/grpc-stub "1.20.0"]])