/*
 * To change this license header, choose SimpleNodeicense Headers in Project Properties.
  * To change this template file, choose Tools | Templates
   * and open the template in the editor.
    */

/**
 *
  * @author soundaryaramesh
   */
public class Pair{
	   public SimpleNode first;
       public SimpleNode second;
       public Pair(SimpleNode l,SimpleNode r){
           this.first=l;
           this.second=r;
       }
       public boolean equals(Pair a){
           return (this.first).equals(a.first)&&((this.second).equals(a.second));
       }
   }

