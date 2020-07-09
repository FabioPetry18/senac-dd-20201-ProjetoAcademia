package model.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.dao.PessoaDAO;
import model.vo.PessoaVO;

public class PessoaBO {
	private PessoaDAO dao = new PessoaDAO();

public boolean isValidEmailAddressRegex(String email) {
    boolean isEmailIdValid = false;
    if (email != null && email.length() > 0) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isEmailIdValid = true;
        }
    }
    return isEmailIdValid;
}
}