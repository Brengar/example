import net.*;

import java.util.ArrayList;
import java.util.List;

public class soap {
    public static List<String> checkString(String arg) {
        List<String> result= new ArrayList<String>();
        SpellService service = new SpellService();
        SpellServiceSoap port = service.getSpellServiceSoap();
        CheckTextRequest request = new CheckTextRequest();
        request.setLang("en");
        request.setText(arg);
        CheckTextResponse checkTextResponse = port.checkText(request);
        List<SpellError> errorList = checkTextResponse.getSpellResult().getError();
        for (SpellError error : errorList) {
            result.add(error.getWord());
        }
        return result;
    }
}