package ss4.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 26/05/13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class PrintWindow implements Printable, ActionListener {
    JFrame _frameToPrint;

    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(_frameToPrint, "Error al imprimir.");
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }


        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        _frameToPrint.printAll(graphics);

        return PAGE_EXISTS;
    }
}
