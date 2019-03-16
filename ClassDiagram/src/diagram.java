/*                        +--------------+
                          | OrchardWorld |
                          +--------------+
                          |integer width |
                          |integer height|
                          |basket  basket|------------------------+
                          |bushel  apples|-+					  |
                          +--------------+ |					  |
								 +---------+                      |
								 |                                |
								 |                                |
				   +-------------+---------------+                |
				   |							 |                |
				   V							 V				  |
			+--------------+           +--------------------+     |
			| Empty Bushel |		   |     ConsBushel	    |     |
			+--------------+           +--------------------+ 	  |
			|              |    +------| apple 		  first | 	  |
			+--------------+    |  +---| bushel       rest  |	  |
			                    |  |   +--------------------+ 	  |
								|  |                              |
								|  +----+               +---------+          
								|       |               |
								V       |               V          
				+---------------------+ |  +----------------------+    
				|       Apple         | |  |       Basket         |
				+---------------------+ |  +----------------------+
			+---|CartPt              p| |  | integer           x  |
			|	|Boolean          good| +->| Bushel           acc |
			|	|WorldImage AppleImage|    |WorldImage basketImage|
			|	+---------------------+    +----------------------+
			|
			V
		+------------+
		|   CartPt   |
		+------------+
		|integer   x |
		|integer   y |
		+------------+	


// Apple Picker
// Try to catch as many good apples(red) as you can in your basket without 
// catching a bad one(black). The more apples you catch, the higher your score.
 */




























