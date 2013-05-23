package ss4.util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mlopezh
 * Date: 23/05/13
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
public class DateFormat extends MaskFormatter {
    private SimpleDateFormat _fmt = new SimpleDateFormat("yyyy-MM-dd");

    public DateFormat() throws ParseException {
        super("####-##-##");
    }

    @Override
    public Object stringToValue(String value) throws ParseException {
        return _fmt.parse(value);

    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value instanceof Date) {
            return _fmt.format(value);

        } else {
            return _fmt.format(new Date());
        }
    }
}
