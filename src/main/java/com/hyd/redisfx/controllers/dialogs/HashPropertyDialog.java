package com.hyd.redisfx.controllers.dialogs;

import com.hyd.redisfx.controllers.tabs.HashTabController;
import com.hyd.redisfx.fx.FormDialog;
import com.hyd.redisfx.fx.TextAreaFormField;
import com.hyd.redisfx.fx.TextFormField;
import com.hyd.redisfx.i18n.I18n;
import javafx.event.ActionEvent;

/**
 * (description)
 * created at 2017/7/12
 *
 * @author yidin
 */
public class HashPropertyDialog extends FormDialog {

    private final TextFormField keyField;

    private final TextAreaFormField valueField;

    private HashTabController.HashItem hashItem;

    private Runnable onItemSubmit;

    public HashPropertyDialog(HashTabController.HashItem hashItem) {
        this.hashItem = hashItem;
        this.setTitle("Hash 属性");
        this.setWidth(400);

        keyField = new TextFormField(I18n.getString("word_key") + ": ", hashItem.getKey());
        valueField = new TextAreaFormField(I18n.getString("word_value") + ": ", hashItem.getValue(), 5, true);

        this.addField(keyField);
        this.addField(valueField);
    }

    public void setOnItemSubmit(Runnable onItemSubmit) {
        this.onItemSubmit = onItemSubmit;
    }

    @Override
    protected void okButtonClicked(ActionEvent event) {
        this.hashItem.setKey(this.keyField.getText());
        this.hashItem.setValue(this.valueField.getText());

        if (this.onItemSubmit != null) {
            this.onItemSubmit.run();
        }

        this.close();
    }
}
