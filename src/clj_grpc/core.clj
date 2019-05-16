(ns clj-grpc.core
  (:gen-class)
  (:require [clj-grpc.service])
  (:import
    [io.grpc
     Server
     ServerBuilder]
    [io.grpc.stub StreamObserver]
    [clj-grpc.service GreeterServiceImpl]))

(def SERVER_PORT 50051)

(defn start []
  (let [greeter-service (new GreeterServiceImpl)
        server (-> (ServerBuilder/forPort SERVER_PORT)
                   (.addService greeter-service)
                   (.build)
                   (.start))]
    (-> (Runtime/getRuntime)
        (.addShutdownHook
          (Thread. (fn []
                     (if (not (nil? server))
                       (.shutdown server))))))
    (if (not (nil? server))
      (.awaitTermination server))))

(defn -main
  [& args]
  (print "Now listening on port " SERVER_PORT)
  (start))
