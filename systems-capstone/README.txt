SYSTEMS CAPSTONE - build the HLD building blocks
================================================

Day three you learned caches, rate limiters, load balancers, and sharding as
boxes on a slide. Now you build them, for real, in code.

Six self-contained checkpoints, test-driven. Read systems/RunTests.java first -
the tests are the specification - then fill the TODOs until they pass, one
checkpoint at a time.

  CP1  LRU cache             systems/LruCache.java      O(1) get/put; evict the least-recently-used
  CP2  Rate limiter          systems/TokenBucket.java   token bucket with an injected clock (deterministic)
  CP3  Load balancer         systems/LoadBalancer.java  round-robin + least-connections (the Strategy pattern)
  CP4  LFU cache             systems/LfuCache.java       evict the least-frequently-used; ties by recency
  CP5  Consistent hashing    systems/HashRing.java       a ring with virtual nodes; a removed node moves only its keys
  CP6  Raft leader election  systems/RaftCluster.java   (boss) simplified election: terms, one vote each, majority

Run it:
  Windows:        run.cmd
  macOS / Linux:  ./run.sh
  By hand:        javac systems/*.java  &&  java systems.RunTests

The starter compiles and most tests fail on the TODO stubs - make them green
checkpoint by checkpoint. CP6 is an optional boss level: a deliberately simplified
model of Raft leader election - no timeouts, threads, or logs, just the safety
core (a node grants at most one vote per term; a majority wins; a higher term
supersedes). Full Raft is a multi-week project; this is the idea, in one sitting.

Notice the callbacks to day two: the load balancer and the cache eviction policy
are the Strategy pattern; swapping how requests are routed is a one-line change.
That is the whole point - the HLD blocks are just good LLD, wearing systems names.
