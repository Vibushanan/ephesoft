/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.gwt.admin.bm.client.view.regex;

import com.ephesoft.dcma.gwt.admin.bm.client.AdminConstants;
import com.ephesoft.dcma.gwt.admin.bm.client.i18n.BatchClassManagementConstants;
import com.ephesoft.dcma.gwt.admin.bm.client.presenter.regex.EditRegexPresenter;
import com.ephesoft.dcma.gwt.core.client.View;
import com.ephesoft.dcma.gwt.core.client.i18n.LocaleDictionary;
import com.ephesoft.dcma.gwt.core.client.validator.RegExValidatableWidget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class provides functionality to edit regex view.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.gwt.core.client.View
 */
public class EditRegexView extends View<EditRegexPresenter> {

	/**
	 * UI binder.
	 */
	interface Binder extends UiBinder<VerticalPanel, EditRegexView> {
	}

	/**
	 * patternLabel Label.
	 */
	@UiField
	protected Label patternLabel;

	/**
	 * To get Pattern Label.
	 * 
	 * @return Label
	 */
	public Label getPatternLabel() {
		return patternLabel;
	}

	/**
	 * To set Pattern Label.
	 * 
	 * @param patternLabel Label
	 */
	public void setPatternLabel(Label patternLabel) {
		this.patternLabel = patternLabel;
	}

	/**
	 * patternStar Label.
	 */
	@UiField
	protected Label patternStar;

	/**
	 * pattern TextBox.
	 */
	@UiField
	protected TextBox pattern;

	/**
	 * validatePatternButton Button.
	 */
	@UiField
	protected Button validatePatternButton;

	/**
	 * saveButton Button.
	 */
	@UiField
	protected Button saveButton;

	/**
	 * cancelButton Button.
	 */
	@UiField
	protected Button cancelButton;

	/**
	 * samplePatternButton Button.
	 */
	@UiField
	protected Button samplePatternButton;

	/**
	 * validatePatternTextBox RegExValidatableWidget<TextBox>.
	 */
	private final RegExValidatableWidget<TextBox> validatePatternTextBox;

	/**
	 * editRegexViewPanel VerticalPanel.
	 */
	@UiField
	protected VerticalPanel editRegexViewPanel;

	/**
	 * Instantiates a class via deferred binding.
	 */
	private static final Binder BINDER = GWT.create(Binder.class);

	/**
	 * Constructor.
	 */
	public EditRegexView() {
		super();
		initWidget(BINDER.createAndBindUi(this));
		saveButton.setText(AdminConstants.OK_BUTTON);
		cancelButton.setText(AdminConstants.CANCEL_BUTTON);
		samplePatternButton.setText(AdminConstants.SAMPLE_REGEX_BUTTON);
		validatePatternButton.setTitle(AdminConstants.VALIDATE_BUTTON);
		validatePatternButton.setStyleName(AdminConstants.VALIDATE_BUTTON_IMAGE);
		validatePatternTextBox = new RegExValidatableWidget<TextBox>(pattern);
		validatePatternTextBox.getWidget().addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				validatePatternTextBox.setValid(false);
			}
		});
		editRegexViewPanel.setSpacing(BatchClassManagementConstants.FIVE);

		patternLabel.setText(LocaleDictionary.get().getConstantValue(BatchClassManagementConstants.PATTERN) + AdminConstants.COLON);
		patternStar.setText(AdminConstants.STAR);
		patternStar.setStyleName(AdminConstants.FONT_RED_STYLE);
		patternLabel.setStyleName(AdminConstants.BOLD_TEXT_STYLE);
	}

	/**
	 * To save changes on save click.
	 * 
	 * @param clickEvent ClickEvent
	 */
	@UiHandler("saveButton")
	public void onSaveClicked(ClickEvent clickEvent) {
		presenter.onSave();
	}

	/**
	 * To cancel changes on cancel click.
	 * 
	 * @param clickEvent ClickEvent
	 */
	@UiHandler("cancelButton")
	public void onCancelClicked(ClickEvent clickEvent) {
		presenter.onCancel();
	}

	/**
	 * To perform operations on Sample Pattern Button Clicked .
	 * 
	 * @param clickEvent ClickEvent
	 */
	@UiHandler("samplePatternButton")
	public void onSamplePatternButtonClicked(ClickEvent clickEvent) {
		presenter.getController().getMainPresenter().getSamplePatterns();
	}

	/**
	 * To perform operations on Validate Pattern Button Clicked.
	 * 
	 * @param clickEvent ClickEvent
	 */
	@UiHandler("validatePatternButton")
	public void onValidatePatternButtonClicked(ClickEvent clickEvent) {
		presenter.onValidatePatternButtonClicked();
	}

	/**
	 * To set Pattern.
	 * 
	 * @param keyPattern String
	 */
	public void setPattern(String keyPattern) {
		this.pattern.setValue(keyPattern);
	}

	/**
	 * To get Pattern.
	 * 
	 * @return String
	 */
	public String getPattern() {
		return this.pattern.getValue();
	}

	/**
	 * To get Validate Pattern Text Box.
	 * 
	 * @return RegExValidatableWidget<TextBox>
	 */
	public RegExValidatableWidget<TextBox> getValidatePatternTextBox() {
		return validatePatternTextBox;
	}

	/**
	 * To get Pattern Text Box.
	 * 
	 * @return TextBox
	 */
	public TextBox getPatternTextBox() {
		return pattern;
	}

	/**
	 * To set Save Button enable.
	 * 
	 * @param isEnable boolean
	 */
	public void setSaveButtonEnable(boolean isEnable) {
		saveButton.setEnabled(isEnable);

	}

}
