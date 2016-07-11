/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011-2016 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.keywordsearch;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.coreutils.Logger;

/**
 * A panel to manage all keyword lists created/imported in Autopsy.
 */
class GlobalListsManagementPanel extends javax.swing.JPanel implements OptionsPanel {

    private static final long serialVersionUID = 1L;

    private Logger logger = Logger.getLogger(GlobalListsManagementPanel.class.getName());
    private KeywordListTableModel tableModel;
    private KeywordSearchSettingsManager manager;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final org.sleuthkit.autopsy.keywordsearch.GlobalListSettingsPanel globalListSettingsPanel;

    @Messages({"GlobalListsManagementPanel.settingsLoadFail.message=Failed to load keyword settings, using defaults.",
        "GlobalListsManagementPanel.settingsLoadFail.title=Load Failed"})
    GlobalListsManagementPanel(KeywordSearchSettingsManager manager, GlobalListSettingsPanel gsp) {
        this.globalListSettingsPanel = gsp;
        tableModel = new KeywordListTableModel();
        this.manager = manager;
        initComponents();
        customizeComponents();
        enableComponents();
        if (this.manager == null) {
            this.importButton.setEnabled(false);
            this.jScrollPane1.setEnabled(false);
            this.listsTable.setEnabled(false);
            this.newListButton.setEnabled(false);
        }
    }

    private void customizeComponents() {
        listsTable.setAutoscrolls(true);
        listsTable.setTableHeader(null);
        listsTable.setShowHorizontalLines(false);
        listsTable.setShowVerticalLines(false);

        listsTable.getParent().setBackground(listsTable.getBackground());

        listsTable.setCellSelectionEnabled(false);
        listsTable.setRowSelectionAllowed(true);
        tableModel.resync();

        listsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                globalListSettingsPanel.setFocusOnKeywordTextBox();
            }
        });
        /*
         * XmlKeywordListImportExport.getCurrent().addPropertyChangeListener(new
         * PropertyChangeListener() {
         *
         * @Override public void propertyChange(PropertyChangeEvent evt) { if
         * (evt.getPropertyName().equals(XmlKeywordListImportExport.ListsEvt.LIST_ADDED.toString()))
         * { tableModel.resync(); for(int i = 0; i<listsTable.getRowCount();
         * i++) { String name = (String) listsTable.getValueAt(i, 0);
         * if(((String) evt.getNewValue()).equals(name)) {
         * listsTable.getSelectionModel().setSelectionInterval(i, i); } } } else
         * if
         * (evt.getPropertyName().equals(XmlKeywordListImportExport.ListsEvt.LIST_DELETED.toString()))
         * { tableModel.resync(); if(listsTable.getRowCount() > 0) {
         * listsTable.getSelectionModel().setSelectionInterval(0, 0); } else {
         * listsTable.getSelectionModel().clearSelection(); } } } });
         */
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    /**
     * Enables the components of this panel based upon whether or not the
     * settings could be loaded.
     */
    private void enableComponents() {
        boolean enable = this.manager != null;
        this.importButton.setEnabled(enable);
        this.jScrollPane1.setEnabled(enable);
        this.listsTable.setEnabled(enable);
        this.newListButton.setEnabled(enable);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listsTable = new javax.swing.JTable();
        newListButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        keywordListsLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(250, 0));

        listsTable.setModel(tableModel);
        listsTable.setMaximumSize(new java.awt.Dimension(30000, 30000));
        listsTable.setShowHorizontalLines(false);
        listsTable.setShowVerticalLines(false);
        listsTable.getTableHeader().setReorderingAllowed(false);
        listsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listsTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listsTable);

        newListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/keywordsearch/new16.png"))); // NOI18N
        newListButton.setText(org.openide.util.NbBundle.getMessage(GlobalListsManagementPanel.class, "GlobalListsManagementPanel.newListButton.text")); // NOI18N
        newListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newListButtonActionPerformed(evt);
            }
        });

        importButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/keywordsearch/import16.png"))); // NOI18N
        importButton.setText(org.openide.util.NbBundle.getMessage(GlobalListsManagementPanel.class, "GlobalListsManagementPanel.importButton.text")); // NOI18N
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        keywordListsLabel.setText(org.openide.util.NbBundle.getMessage(GlobalListsManagementPanel.class, "GlobalListsManagementPanel.keywordListsLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keywordListsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(keywordListsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newListButton)
                    .addComponent(importButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 @Messages({"GlobalListsManagementPanel.newListFail.message=Failed to add the new list to the settings.",
        "GlobalListsManagementPanel.newListFail.title=New List Failed"})
    private void newListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newListButtonActionPerformed
     String listName = (String) JOptionPane.showInputDialog(null, NbBundle.getMessage(this.getClass(), "KeywordSearch.newKwListTitle"),
             NbBundle.getMessage(this.getClass(), "KeywordSearch.newKeywordListMsg"), JOptionPane.PLAIN_MESSAGE, null, null, "");
     if (listName == null || listName.trim().equals("")) {
         return;
     }
     boolean shouldAdd = false;
     KeywordList listWithSameName = null;
     List<KeywordList> keywordLists = manager.getKeywordLists();
     for (int i = 0; i < keywordLists.size(); i++) {
         KeywordList currList = keywordLists.get(i);
         if (currList.getName().equals(listName)) {
             listWithSameName = currList;
             i = keywordLists.size();
         }
     }
     if (listWithSameName != null) {
         if (listWithSameName.isLocked()) {
             boolean replace = KeywordSearchUtil.displayConfirmDialog(
                     NbBundle.getMessage(this.getClass(), "KeywordSearch.newKeywordListMsg"),
                     NbBundle.getMessage(this.getClass(), "KeywordSearchListsManagementPanel.newKeywordListDescription", listName),
                     KeywordSearchUtil.DIALOG_MESSAGE_TYPE.WARN);
             if (replace) {
                 shouldAdd = true;
             }
         } else {
             boolean replace = KeywordSearchUtil.displayConfirmDialog(
                     NbBundle.getMessage(this.getClass(), "KeywordSearch.newKeywordListMsg"),
                     NbBundle.getMessage(this.getClass(), "KeywordSearchListsManagementPanel.newKeywordListDescription2", listName),
                     KeywordSearchUtil.DIALOG_MESSAGE_TYPE.WARN);
             if (replace) {
                 shouldAdd = true;
             }
         }
     } else {
         shouldAdd = true;
     }
     if (shouldAdd) {
         try {
             manager.addList(new KeywordList(listName, new Date(), new Date(), false, false, new ArrayList<Keyword>()));
         } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
             JOptionPane.showMessageDialog(null, Bundle.GlobalListsManagementPanel_newListFail_message(), Bundle.GlobalListsManagementPanel_newListFail_title(), JOptionPane.ERROR_MESSAGE);
             logger.log(Level.SEVERE, "Failed to add list to settings.", ex);
         }
     }
     tableModel.resync();

     //This loop selects the recently ADDED keywordslist in the JTable
     for (int i = 0; i < listsTable.getRowCount(); i++) {
         if (listsTable.getValueAt(i, 0).equals(listName)) {
             listsTable.getSelectionModel().addSelectionInterval(i, i);
         }
     }
     pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    globalListSettingsPanel.setFocusOnKeywordTextBox();
    }//GEN-LAST:event_newListButtonActionPerformed
    @Messages({"GlobalListsManagementPanel.deleteListFail.message=Failed to delete list from settings.",
        "GlobalListsManagementPanel.deleteListFail.title=Delete List Failed"})
    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        final String[] AUTOPSY_EXTENSIONS = new String[]{"xml"}; //NON-NLS
        final String[] ENCASE_EXTENSIONS = new String[]{"txt"}; //NON-NLS
        FileNameExtensionFilter autopsyFilter = new FileNameExtensionFilter(
                NbBundle.getMessage(this.getClass(), "KeywordSearchListsManagementPanel.fileExtensionFilterLbl"), AUTOPSY_EXTENSIONS);
        FileNameExtensionFilter encaseFilter = new FileNameExtensionFilter(
                NbBundle.getMessage(this.getClass(), "KeywordSearchListsManagementPanel.fileExtensionFilterLb2"), ENCASE_EXTENSIONS);
        chooser.addChoosableFileFilter(autopsyFilter);
        chooser.addChoosableFileFilter(encaseFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        String listName = null;
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selFile = chooser.getSelectedFile();
            if (selFile == null) {
                return;
            }

            //force append extension if not given
            String fileAbs = selFile.getAbsolutePath();

            if (KeywordSearchUtil.isXMLList(fileAbs)) {
                XmlKeywordListImportExport reader = new XmlKeywordListImportExport(fileAbs);
                List<KeywordList> toImport = reader.load();
                if (toImport == null) {
                    KeywordSearchUtil.displayDialog(
                            NbBundle.getMessage(this.getClass(), "KeywordSearch.listImportFeatureTitle"), NbBundle.getMessage(this.getClass(), "KeywordSearch.importListFileDialogMsg", fileAbs), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.ERROR);
                    return;
                }
                for (KeywordList list : toImport) {
                    //check name collisions
                    listName = list.getName();
                    List<KeywordList> keywordLists = manager.getKeywordLists();
                    boolean listExists = false;
                    for (int i = 0; i < keywordLists.size(); i++) {
                        KeywordList currList = keywordLists.get(i);
                        if (currList.getName().equals(listName)) {
                            listExists = true;
                            i = keywordLists.size();
                        }
                    }
                    if (listExists) {
                        Object[] options = {NbBundle.getMessage(this.getClass(), "KeywordSearch.yesOwMsg"),
                            NbBundle.getMessage(this.getClass(), "KeywordSearch.noSkipMsg"),
                            NbBundle.getMessage(this.getClass(), "KeywordSearch.cancelImportMsg")};
                        int choice = JOptionPane.showOptionDialog(this,
                                NbBundle.getMessage(this.getClass(), "KeywordSearch.overwriteListPrompt", listName),
                                NbBundle.getMessage(this.getClass(), "KeywordSearch.importOwConflict"),
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);
                        if (choice == JOptionPane.OK_OPTION) {
                            try {
                                manager.updateList(list);
                            } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
                                KeywordSearchUtil.displayDialog(
                                        NbBundle.getMessage(this.getClass(), "KeywordSearch.listImportFeatureTitle"), NbBundle.getMessage(this.getClass(), "KeywordSearch.kwListFailImportMsg"), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.INFO);

                            }
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            break;
                        }

                    } else {
                        try {
                            //no conflict
                            manager.addList(list);
                        } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
                            KeywordSearchUtil.displayDialog(
                                    NbBundle.getMessage(this.getClass(), "KeywordSearch.listImportFeatureTitle"), NbBundle.getMessage(this.getClass(), "KeywordSearch.kwListFailImportMsg"), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.INFO);

                        }
                    }

                }
            } else {
                EnCaseKeywordListImport reader = new EnCaseKeywordListImport();
                KeywordList keywordList = reader.load(fileAbs);
                if (keywordList == null) {
                    KeywordSearchUtil.displayDialog(
                            NbBundle.getMessage(this.getClass(), "KeywordSearch.listImportFeatureTitle"), NbBundle.getMessage(this.getClass(), "KeywordSearch.importListFileDialogMsg", fileAbs), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.ERROR);
                    return;
                }

                List<KeywordList> toImport = new ArrayList<>();
                toImport.add(keywordList);
                for (KeywordList list : toImport) {
                    //check name collisions
                    listName = list.getName();
                    List<KeywordList> keywordLists = manager.getKeywordLists();
                    boolean listExists = false;
                    for (int i = 0; i < keywordLists.size(); i++) {
                        KeywordList currList = keywordLists.get(i);
                        if (currList.getName().equals(listName)) {
                            listExists = true;
                            i = keywordLists.size();
                        }
                    }
                    if (listExists) {
                        Object[] options = {NbBundle.getMessage(this.getClass(), "KeywordSearch.yesOwMsg"),
                            NbBundle.getMessage(this.getClass(), "KeywordSearch.noSkipMsg"),
                            NbBundle.getMessage(this.getClass(), "KeywordSearch.cancelImportMsg")};
                        int choice = JOptionPane.showOptionDialog(this,
                                NbBundle.getMessage(this.getClass(), "KeywordSearch.overwriteListPrompt", listName),
                                NbBundle.getMessage(this.getClass(), "KeywordSearch.importOwConflict"),
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);
                        if (choice == JOptionPane.OK_OPTION) {
                            try {
                                manager.updateList(list);
                            } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
                                KeywordSearchUtil.displayDialog(
                                        NbBundle.getMessage(this.getClass(), "KeywordSearch.listImportFeatureTitle"), NbBundle.getMessage(this.getClass(), "KeywordSearch.kwListFailImportMsg"), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.INFO);

                            }
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            break;
                        }

                    } else {
                        try {
                            //no conflict
                            manager.addList(list);
                        } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
                            KeywordSearchUtil.displayDialog(
                                    NbBundle.getMessage(this.getClass(), "KeywordSearch.listImportFeatureTitle"), NbBundle.getMessage(this.getClass(), "KeywordSearch.kwListFailImportMsg"), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.INFO);

                        }
                    }

                }
            }

        }
        tableModel.resync();

        //This loop selects the recently IMPORTED keywordslist in the JTable
        if (listName != null) {
            for (int i = 0; i < listsTable.getRowCount(); i++) {
                if (listsTable.getValueAt(i, 0).equals(listName)) {
                    listsTable.getSelectionModel().addSelectionInterval(i, i);
                }
            }
        }
        pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_importButtonActionPerformed
    private void listsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listsTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int[] selected = listsTable.getSelectedRows();
            if (selected.length == 0) {
                return;
            } else if (KeywordSearchUtil.displayConfirmDialog(NbBundle.getMessage(this.getClass(), "KeywordSearchConfigurationPanel1.customizeComponents.title"), NbBundle.getMessage(this.getClass(), "KeywordSearchConfigurationPanel1.customizeComponents.body"), KeywordSearchUtil.DIALOG_MESSAGE_TYPE.WARN)) {
                String listName = (String) listsTable.getModel().getValueAt(selected[0], 0);
                KeywordList listWithSameName = null;
                List<KeywordList> keywordLists = manager.getKeywordLists();
                for (int i = 0; i < keywordLists.size(); i++) {
                    KeywordList currList = keywordLists.get(i);
                    if (currList.getName().equals(listName)) {
                        listWithSameName = currList;
                        i = keywordLists.size();
                    }
                }
                if (listWithSameName != null) {
                    try {
                        manager.removeList(listWithSameName);
                    } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
                        JOptionPane.showMessageDialog(null, Bundle.GlobalListsManagementPanel_deleteListFail_message(), Bundle.GlobalListsManagementPanel_deleteListFail_title(), JOptionPane.ERROR_MESSAGE);
                    }
                }
                pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
            } else {
                return;
            }
        }
        tableModel.resync();
    }//GEN-LAST:event_listsTableKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton importButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel keywordListsLabel;
    private javax.swing.JTable listsTable;
    private javax.swing.JButton newListButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void store() {
        // Implemented by parent panel
    }

    @Override
    public void load() {
        listsTable.clearSelection();
    }

    void resync() {
        tableModel.resync();
    }

    private class KeywordListTableModel extends AbstractTableModel {

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public int getRowCount() {
            int count = 0;
            if (manager != null) {
                for (KeywordList list : manager.getKeywordLists()) {
                    if (!list.isLocked()) {
                        count++;
                    }
                }
            }
            return count;
        }

        @Override
        public String getColumnName(int column) {
            return NbBundle.getMessage(this.getClass(), "KeywordSearchListsManagementPanel.getColName.text");
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (manager != null) {
                for (KeywordList list : manager.getKeywordLists()) {
                    if (rowIndex == 0 && !list.isLocked()) {
                        return list.getName();
                    }
                    if (!list.isLocked()) {
                        rowIndex--;
                    }
                }
            }
            return "";
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException(
                    NbBundle.getMessage(this.getClass(), "KeywordSearchListsManagementPanel.setValueAt.exception.msg"));
        }

        @Override
        public Class<?> getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        //delete selected from handle, events are fired from the handle
        @Messages({"GlobalListsManagementPanel.KeywordListTableModel.failedDelete.message=Couldn't delete selected list.",
            "GlobalListsManagementPanel.KeywordListTableModel.failedDelete.title=Error Deleting List"})
        void deleteSelected(int[] selected) {
            List<String> toDel = new ArrayList<>();
            for (int i = 0; i < selected.length; i++) {
                toDel.add((String) getValueAt(0, selected[i]));
            }
            List<KeywordList> keywordLists = manager.getKeywordLists();
            for (String del : toDel) {
                for (KeywordList list : keywordLists) {
                    if (list.getName().equals(del)) {
                        try {
                            manager.removeList(list);

                        } catch (KeywordSearchSettingsManager.KeywordSearchSettingsManagerException ex) {
                            JOptionPane.showMessageDialog(null, Bundle.KeywordSearchGlobalLanguageSettingsPanel_failedReadSettings_message(),
                                    Bundle.KeywordSearchGlobalLanguageSettingsPanel_failedReadSettings_title(), JOptionPane.ERROR_MESSAGE);
                            logger.log(Level.SEVERE, "Failed to write keyword search settings.", ex);
                        }
                    }
                }
            }
        }

        //resync model from handle, then update table
        void resync() {
            fireTableDataChanged();
        }
    }

    void addListSelectionListener(ListSelectionListener l) {
        listsTable.getSelectionModel().addListSelectionListener(l);
    }
}
