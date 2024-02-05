 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 *
 * @author mimic
 */
   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author bbaral3
 */
public class Lab03 implements MyArray {  
    private String[] arr;
    int logicsize;
    
    public Lab03() {
        arr = new String[10000];
    }
    public Lab03(MyArray mya) {
        arr = new String[mya.size()];
        logicsize = mya.size();
        for (int i = 0; i < mya.size(); i++) {
            arr[i] = mya.get(i);
        }
    }
    public Lab03(MyArray mya, int start, int end) {
        int i = 0;
        int j = start;
        if (start < end) {
            arr = new String[end - start];
            logicsize = end - start;
            while(j < end) {
                arr[i] = mya.get(j);
                i++;
                j++;
            } 
        } else {
        arr = new String[10000];
        }
    }

    public void increment() {
        if (logicsize >= arr.length) {
           String[] newArray = new String[arr.length * 2];
           for (int i = 0; i < arr.length; i++) {
               newArray[i] = arr[i];
           }
           arr = newArray;
        }
    }

    
    @Override
    public String toString() {
        String output = "{";
        if (logicsize > 0) {
        output += get(0);
        for (int i = 1; i < logicsize; i++) {
            output += ", " + get(i);
        }
        }
        output += "}";
        return output;
    }

  
    @Override
    public int size() {
        return logicsize;
    }

  
    @Override
    public void set(int pos, String str) {
        arr[pos] = str;
    }

    @Override
    public String get(int pos) {
        if (pos >= 0 && pos < logicsize) {
            return arr[pos]; 
        } else {
        return null; }     
    }

  
    @Override
    public int get(String str) {
        for (int i = 0; i < logicsize; i++) {
            if (arr[i].equals(str)) {
                return i;
            }
        }
        return (-1);
    }

  
    @Override
    public boolean contains(String str) {
        for (int i = 0; i < logicsize; i++) {
            if (arr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

  
    @Override
    public void append(String str) {
        increment();
        
        arr[logicsize] = str;
        logicsize++;
    }

  
    @Override
    public int insert(int pos, String str) { 
        if (pos >= 0 && pos <= logicsize) {
            
            logicsize++;
            increment();
            for (int i = logicsize; i>pos; i--) {
                arr[i] = arr[i-1];
            }
            arr[pos] = str;
            return pos;
        } else 
        { return -1; }
        
    }
  
    @Override
    public String remove(int pos) {
        if (pos >= 0 && pos < logicsize) {
            String reality = get(pos);
            for (int i = pos + 1; i < logicsize; i++) { 
                arr[i - 1] = arr[i]; 
            }
            logicsize--;
            return reality;
        } else {
        return null;
        }
    }

  
    @Override
    public int remove(String str) {
        int pos;
        for (int i = 0; i < logicsize; i++) {
            if (arr[i].equals(str)) {
                pos = i;
                for (int j = pos; j < logicsize; j++) { 
                    arr[j] = arr[j + 1]; 
                }
                logicsize--;
                return pos;
            }
        }
        return -1;
    }
    
}
    
