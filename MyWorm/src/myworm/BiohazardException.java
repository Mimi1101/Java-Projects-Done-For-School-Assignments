/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myworm;

/**
 *
 * @author mimic
 */

public class BiohazardException extends RuntimeException {
    public BiohazardException(String type) { super("Adding '"+type+"' to a worm is unnatural!"); }
}
