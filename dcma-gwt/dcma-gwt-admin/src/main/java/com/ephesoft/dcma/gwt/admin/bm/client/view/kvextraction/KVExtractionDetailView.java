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

package com.ephesoft.dcma.gwt.admin.bm.client.view.kvextraction;

import com.ephesoft.dcma.core.common.LocationType;
import com.ephesoft.dcma.gwt.admin.bm.client.AdminConstants;
import com.ephesoft.dcma.gwt.admin.bm.client.i18n.BatchClassManagementConstants;
import com.ephesoft.dcma.gwt.admin.bm.client.presenter.kvextraction.KVExtractionDetailPresenter;
import com.ephesoft.dcma.gwt.core.client.View;
import com.ephesoft.dcma.gwt.core.client.i18n.LocaleDictionary;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class provides functionality to show KV extraction detail.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.gwt.core.client.View
 */
public class KVExtractionDetailView extends View<KVExtractionDetailPresenter> {

	/**
	 * UI binder.
	 */
	interface Binder extends UiBinder<VerticalPanel, KVExtractionDetailView> {
	}

	/**
	 * keyPatternLabel Label.
	 */
	@UiField
	protected Label keyPatternLabel;

	/**
	 * keyPattern Label.
	 */
	@UiField
	protected Label keyPattern;

	/**
	 * valuePatternLabel Label.
	 */
	@UiField
	protected Label valuePatternLabel;

	/**
	 * valuePattern Label.
	 */
	@UiField
	protected Label valuePattern;

	/**
	 * locationLabel Label.
	 */
	@UiField
	protected Label locationLabel;

	/**
	 * location Label.
	 */
	@UiField
	protected Label location;

	/**
	 * noOfWordsLabel Label.
	 */
	@UiField
	protected Label noOfWordsLabel;

	/**
	 * noOfWords Label.
	 */
	@UiField
	protected Label noOfWords;

	/**
	 * editKVPropertiesButton Button.
	 */
	@UiField
	protected Button editKVPropertiesButton;

	/**
	 * Instantiates a class via deferred binding.
	 */
	private static final Binder BINDER = GWT.create(Binder.class);

	/**
	 * Constructor.
	 */
	public KVExtractionDetailView() {
		super();
		initWidget(BINDER.createAndBindUi(this));
		keyPatternLabel.setText(LocaleDictionary.get().getConstantValue(BatchClassManagementConstants.KEY_PATTERN)
				+ AdminConstants.COLON);
		valuePatternLabel.setText(LocaleDictionary.get().getConstantValue(BatchClassManagementConstants.VALUE_PATTERN)
				+ AdminConstants.COLON);
		locationLabel.setText(LocaleDictionary.get().getConstantValue(BatchClassManagementConstants.LOCATION) + AdminConstants.COLON);
		noOfWordsLabel.setText(LocaleDictionary.get().getConstantValue(BatchClassManagementConstants.NO_OF_WORDS)
				+ AdminConstants.COLON);

		keyPatternLabel.setStyleName(AdminConstants.BOLD_TEXT_STYLE);
		valuePatternLabel.setStyleName(AdminConstants.BOLD_TEXT_STYLE);
		locationLabel.setStyleName(AdminConstants.BOLD_TEXT_STYLE);
		noOfWordsLabel.setStyleName(AdminConstants.BOLD_TEXT_STYLE);
		editKVPropertiesButton.setText(AdminConstants.EDIT_BUTTON);
	}

	/**
	 * To set Key Pattern.
	 * 
	 * @param keyPattern String
	 */
	public void setKeyPattern(String keyPattern) {
		this.keyPattern.setText(keyPattern);
	}

	/**
	 * To set Value Pattern.
	 * 
	 * @param valuePattern String
	 */
	public void setValuePattern(String valuePattern) {
		this.valuePattern.setText(valuePattern);
	}

	/**
	 * To set location.
	 * 
	 * @param location String
	 */
	public void setlocation(String location) {
		this.location.setText(location);
	}

	/**
	 * To set location.
	 * 
	 * @param location LocationType
	 */
	public void setlocation(LocationType location) {
		if (location != null) {
			this.location.setText(location.name());
		} else {
			this.location.setText(LocationType.LEFT.name());
		}
	}

	/**
	 * To set No Of Words.
	 * 
	 * @param noOfWords String
	 */
	public void setNoOfWords(String noOfWords) {
		this.noOfWords.setText(noOfWords);
	}

	/**
	 * To get Edit KV Properties Button.
	 * 
	 * @return Button
	 */
	public Button getEditKVPropertiesButtonButton() {
		return editKVPropertiesButton;
	}

	/**
	 * To perform operations on Edit KV Properties Button Click.
	 * 
	 * @param clickEvent ClickEvent
	 */
	@UiHandler("editKVPropertiesButton")
	public void onEditKVPropertiesButtonClick(ClickEvent clickEvent) {
		presenter.getController().getBatchClassManagementPresenter().getKvExtractionPresenter().onEditKVPropertiesButtonClicked();
	}

}
