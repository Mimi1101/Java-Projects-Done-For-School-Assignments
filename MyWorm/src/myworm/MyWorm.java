/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myworm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mimic
 */
public class MyWorm implements Worm{

    List <Segment> wormzz;
    Segment head;
    Segment tail;
    
    public MyWorm(){
       wormzz = new LinkedList();
       head = new  Segment();
       tail = new Segment();
    }
    
    public MyWorm(String[] parapipam){
        for(int i = 0;i<parapipam.length; i++){
            add(parapipam[i]);
        }
    }
    @Override
    public Segment getHead() {
       return head;
    }
    
   

    @Override
    public Segment getTail() {
        
        return tail;
        
    }

    @Override
    public void add(String type) {
       boolean found = false;
       
       
       for(int i = 0; i<Segment.SEGMENT_TYPES.length; i++){
           if( Segment.SEGMENT_TYPES[i].equals(type))
               found = true;
       }
       if(!false){
           throw new BiohazardException(type);
       }
        Segment n = new Segment();
        n.type = type;
        n.forwardVessel = getTail();
        if(head == null){
            head = n;
        }
        tail.backwardVessel = n;
       n = tail;
    }

    @Override
    public Worm split(int pos) {
        Worm second = new MyWorm();
        Segment split = getSegment(pos+1);
        if(split == null){
            return second;
        }
        second = split.
        
            }

    @Override
    public void splice(int pos, Worm second) {
        Worm third = split(pos-1);
        for(int i = 0;i<second.dissect().size(); i++){
            this.add(second.dissect().get(i));
            }
        for(int i = 0;i<third.dissect().size(); i++){
            this.add(second.dissect().get(i));
        }
    }

    @Override
    public ArrayList<String> dissect() {
        ArrayList<String> wormname = new ArrayList<String>();
        
        for(Segment c: wormzz){
            c = head;
            wormname.add(c.type);
        }
        
        head = null;
        tail = null;
        
        return wormname;
    }
        
        

    @Override
    public Worm cloneWorm() {
        MyWorm wy = new MyWorm();
        for(int i = 0; i<wormzz.size(); i++){
            wy.add(wormzz.type);
            
        }
        return wy;
        
    }

    @Override
    public Segment getSegment(int n) {
        Segment hehe = new Segment();
        hehe = head;
        for(int i = 0; i<n; i++){
          hehe = wormzz.get(i);
        }
        return hehe;
    }
    
}
