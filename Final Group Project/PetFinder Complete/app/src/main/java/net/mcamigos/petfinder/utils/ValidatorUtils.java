package net.mcamigos.petfinder.utils;

import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;


public class ValidatorUtils {

    /* validate fields if empty*/
    public static boolean validate(EditText[] fields) {

        for (EditText currentField : fields) {
            if (currentField.getText().toString().length() <= 0) {
             //  AlertUtills.showErrorToast(currentField.getHint() + " is required");

                TextInputLayout parent = (TextInputLayout) currentField.getParent().getParent();
                String hint = parent.getHint().toString();
                currentField.setError(hint + " is required");
                return false;
            }
        }
        return true;
    }

    /* validate email */
    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /* validate phone number */
    public static boolean isValidMobile(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }

    public static void clearEditText(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearEditText((ViewGroup)view);
        }
    }

}
