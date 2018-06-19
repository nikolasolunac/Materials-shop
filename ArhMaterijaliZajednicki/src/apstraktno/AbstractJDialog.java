/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apstraktno;

import java.awt.Frame;

/**
 *
 * @author SOLUNAC
 */
public abstract class AbstractJDialog extends javax.swing.JDialog{
    
    public abstract void osvezi();
    
    public AbstractJDialog (Frame owner, boolean modal){
        super (owner, modal);
    }
}
