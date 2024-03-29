/*

     +-------------------------+
     | Traversal<T>            |<...................................................
     +-------------------------+                                                 : :
     | boolean      isEmpty()  |                                                 : :
     | T            getFirst() |                                                 : :
     | Traversal<T> getRest()  |                                                 : :
     +-------------------------+                                                 : :
          / \            / \                                                     : :
          ---            ---                                                     : :
           |              |                                                      : :
      +------------+      +------------------+                                   : :
      | IList<T>   |<-+                      |                                   : :
      +------------+  |             +-----------------------------------------+  : :
          / \         |             | WrapAL<T>                               |  : :
          ---         +-----------+ +-----------------------------------------+  : :
           |                      | | ArrayList<T> arrlist                    |  : :
    -------------------           | | int          first                      |  : :
    |                 |           | +-----------------------------------------+  : :
+-----------+  +----------------+ | | public WrapAL<T>(ArrayList<T> arrlist)  |  : :
| MTList<T> |  | ConsList<T>    | | | private WrapAL<T>(ArrayList<T> arrlist, |  : :
+-----------+  +----------------+ | |                      int first)         |  : :
               | T        first | | +-----------------------------------------+  : :
               | IList<T> rest  |-+                                              : :
               +----------------+                                                : :
                                          +-----------------------------------+  : :
                                          | Algorithms                        |  : :
                                          +-----------------------------------+  : :
                ..........................| boolean orMap(Traversal<T> tr,    |..: :
                :                         |               Predicate<T> pick)  |    :
                :                 ........| int    countSuch(Traversal<T> tr, |    :
                :                 :       |                Predicate<T> pick) |....:               
                :                 :       +-----------------------------------+
                v                 v           
           +-----------------------------+
           | Predicate<T>                |
           +-----------------------------+
           | boolean apply(T t)          |
           +-----------------------------+
            / \                       / \
            ---                       ---
             |                         |
+--------------------------+  +--------------------------+
| <Balloon>                |  | <Balloon>                |
| RedBalloon               |  | SmallBalloon             |
+--------------------------+  +--------------------------+
| boolean apply(Balloon b) |  | boolean apply(Balloon b) |
+--------------------------+  +--------------------------+

    
 
+----------
| Examples
+--------------
| Traversal<Balloon> blist: ConsList<Balloon> |
...
| ISelect<Balloon> redBalloon: RedBalloon
...
| Algorithms methods: Algorithms
|......................
| algo.orMap(blist, redBalloon) -> boolean |
...
*/