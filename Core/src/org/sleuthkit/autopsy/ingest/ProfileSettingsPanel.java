/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-2017 Basis Technology Corp.
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
package org.sleuthkit.autopsy.ingest;

import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.ingest.IngestProfileList.IngestProfile;
import org.sleuthkit.autopsy.modules.interestingitems.FilesSet;
import org.sleuthkit.autopsy.modules.interestingitems.FilesSetsManager;

class ProfileSettingsPanel extends IngestModuleGlobalSettingsPanel implements OptionsPanel {
@NbBundle.Messages({"ProfileSettingsPanel.title=Profile Settings", 
    "ProfileSettingsPanel.profileListLabel.text=Profiles:", 
    "ProfileSettingsPanel.profileDescLabel.text=Profile Description:",
    "ProfileSettingsPanel.filterNameLabel.text=Filter:",
    "ProfileSettingsPanel.filterDescLabel.text=Filter Description:",
    "ProfileSettingsPanel.selectedModulesLabel.text=Selected Ingest Modules:",
    "ProfileSettingsPanel.newProfileButton.text=New Profile",
    "ProfileSettingsPanel.editProfileButton.text=Edit Profile",
    "ProfileSettingsPanel.deleteProfileButton.text=Delete Profile",
    "ProfileSettingsPanel.messages.filterLoadFailed=Failed to load file ingest filter"
})
    
    private final DefaultListModel<IngestProfile> profilesListModel = new DefaultListModel<>();

    /**
     * Creates new form ProfileOptionsPanel
     */
    ProfileSettingsPanel() {
        initComponents();
        this.profileList.setModel(profilesListModel);
        this.profileList.addListSelectionListener(new ProfileSettingsPanel.ProfileListSelectionListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileListPane = new javax.swing.JScrollPane();
        profileList = new javax.swing.JList<>();
        profileListLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        newProfileButton = new javax.swing.JButton();
        editProfileButton = new javax.swing.JButton();
        deleteProfileButton = new javax.swing.JButton();
        profileDescPane = new javax.swing.JScrollPane();
        profileDescArea = new javax.swing.JTextArea();
        profileDescLabel = new javax.swing.JLabel();
        filterNameLabel = new javax.swing.JLabel();
        filterNameText = new javax.swing.JLabel();
        filterDescLabel = new javax.swing.JLabel();
        filterDescPane = new javax.swing.JScrollPane();
        filterDescArea = new javax.swing.JTextArea();
        selectedModulesPane = new javax.swing.JScrollPane();
        selectedModulesArea = new javax.swing.JTextArea();
        selectedModulesLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        profileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        profileListPane.setViewportView(profileList);

        org.openide.awt.Mnemonics.setLocalizedText(profileListLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.profileListLabel.text")); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        org.openide.awt.Mnemonics.setLocalizedText(newProfileButton, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.newProfileButton.text")); // NOI18N
        newProfileButton.setMaximumSize(new java.awt.Dimension(97, 23));
        newProfileButton.setMinimumSize(new java.awt.Dimension(97, 23));
        newProfileButton.setPreferredSize(new java.awt.Dimension(97, 23));
        newProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProfileButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(editProfileButton, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.editProfileButton.text")); // NOI18N
        editProfileButton.setMaximumSize(new java.awt.Dimension(97, 23));
        editProfileButton.setMinimumSize(new java.awt.Dimension(97, 23));
        editProfileButton.setPreferredSize(new java.awt.Dimension(97, 23));
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteProfileButton, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.deleteProfileButton.text")); // NOI18N
        deleteProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProfileButtonActionPerformed(evt);
            }
        });

        profileDescArea.setEditable(false);
        profileDescArea.setBackground(new java.awt.Color(240, 240, 240));
        profileDescArea.setColumns(20);
        profileDescArea.setLineWrap(true);
        profileDescArea.setRows(5);
        profileDescArea.setMinimumSize(new java.awt.Dimension(10, 22));
        profileDescArea.setPreferredSize(new java.awt.Dimension(14, 40));
        profileDescPane.setViewportView(profileDescArea);

        org.openide.awt.Mnemonics.setLocalizedText(profileDescLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.profileDescLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(filterNameLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.filterNameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(filterDescLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.filterDescLabel.text")); // NOI18N

        filterDescArea.setEditable(false);
        filterDescArea.setBackground(new java.awt.Color(240, 240, 240));
        filterDescArea.setColumns(20);
        filterDescArea.setRows(5);
        filterDescArea.setMinimumSize(new java.awt.Dimension(10, 40));
        filterDescArea.setPreferredSize(new java.awt.Dimension(14, 42));
        filterDescPane.setViewportView(filterDescArea);

        selectedModulesArea.setEditable(false);
        selectedModulesArea.setBackground(new java.awt.Color(240, 240, 240));
        selectedModulesArea.setColumns(20);
        selectedModulesArea.setLineWrap(true);
        selectedModulesArea.setRows(5);
        selectedModulesPane.setViewportView(selectedModulesArea);

        org.openide.awt.Mnemonics.setLocalizedText(selectedModulesLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.selectedModulesLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profileListLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileListPane)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterDescPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(profileDescPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectedModulesPane, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterDescLabel)
                            .addComponent(selectedModulesLabel)
                            .addComponent(profileDescLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(330, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(564, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileListLabel)
                    .addComponent(profileDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profileDescPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filterNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterDescLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterDescPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(selectedModulesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedModulesPane))
                    .addComponent(profileListPane, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProfileButton))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProfileButtonActionPerformed
        doProfileDialog(null);
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_newProfileButtonActionPerformed

    private void deleteProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProfileButtonActionPerformed
        IngestProfile selectedProfile = this.profileList.getSelectedValue();
        this.profilesListModel.removeElement(selectedProfile);
        IngestProfile.deleteProfile(selectedProfile);

        // Select the first of the remaining set definitions. This will cause
        // the selection listeners to repopulate the subordinate components.
        this.resetComponents();
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_deleteProfileButtonActionPerformed

    private void resetComponents() {
        if (!this.profilesListModel.isEmpty()) {
            this.profileList.setSelectedIndex(0);
        } else {
            this.profilesListModel.clear();
            this.profileDescArea.setText("");
            this.filterDescArea.setText("");
            this.filterNameText.setText("");
            this.selectedModulesArea.setText("");
        }
    }
    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        IngestProfile selectedProfile = profileList.getSelectedValue();
        doProfileDialog(selectedProfile);
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_editProfileButtonActionPerformed

    private void doProfileDialog(IngestProfile selectedProfile) {
        // Create a files set defintion panle.
        ProfilePanel panel;
        if (selectedProfile != null) {
            // Editing an existing set definition.
            panel = new ProfilePanel(selectedProfile);
        } else {
            // Creating a new set definition.
            panel = new ProfilePanel();
        }
        // Do a dialog box with the profilePanel till the user enters a name or chooses cancel
        int option = JOptionPane.OK_OPTION;
        do {
        option = JOptionPane.showConfirmDialog(null, panel,Bundle.ProfileSettingsPanel_title(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        } while (option == JOptionPane.OK_OPTION && !panel.isValidDefinition());

        if (option == JOptionPane.OK_OPTION) {
            panel.saveSettings();
            load();
        }

    }

    @Override
    public void saveSettings() {

    }

    @Override
    public void store() {

    }

    @Override
    public void load() {
        int currentIndex = profileList.getSelectedIndex();
        profilesListModel.clear();
        IngestProfileList iList = new IngestProfileList();
        iList.loadProfileList();
        for (IngestProfile profile : iList.profileList) {
            profilesListModel.addElement(profile);
        }
        if (profilesListModel.isEmpty()) {
            editProfileButton.setEnabled(false);
            deleteProfileButton.setEnabled(false);
        } else {
            editProfileButton.setEnabled(true);
            deleteProfileButton.setEnabled(true);
        }
        profileList.setSelectedIndex(currentIndex);
    }

    private final class ProfileListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }

            // Get the selected interesting files set and populate the set
            // components.
            IngestProfile selectedProfile = ProfileSettingsPanel.this.profileList.getSelectedValue();
            if (selectedProfile != null) {
                profileDescArea.setText(selectedProfile.getDescription());
                filterNameText.setText(selectedProfile.getFileIngestFilter());
                try {
                    Map<String, FilesSet> fileIngestFilters = FilesSetsManager.getInstance().getCustomFileIngestFilters();
                    for (FilesSet fSet : FilesSetsManager.getStandardFileIngestFilters()) {
                        fileIngestFilters.put(fSet.getName(), fSet);
                    }
                    filterDescArea.setText(fileIngestFilters.get(selectedProfile.getFileIngestFilter()).getDescription());
                } catch (FilesSetsManager.FilesSetsManagerException ex) {
                    filterDescArea.setText(NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.messages.filterLoadFailed")); 
                }
                selectedModulesArea.setText("");
                for (String moduleName : selectedProfile.getModuleNames(IngestProfile.getEnabledModulesKey())) {
                    selectedModulesArea.append(moduleName + "\n");
                }

            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteProfileButton;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JTextArea filterDescArea;
    private javax.swing.JLabel filterDescLabel;
    private javax.swing.JScrollPane filterDescPane;
    private javax.swing.JLabel filterNameLabel;
    private javax.swing.JLabel filterNameText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton newProfileButton;
    private javax.swing.JTextArea profileDescArea;
    private javax.swing.JLabel profileDescLabel;
    private javax.swing.JScrollPane profileDescPane;
    private javax.swing.JList<IngestProfile> profileList;
    private javax.swing.JLabel profileListLabel;
    private javax.swing.JScrollPane profileListPane;
    private javax.swing.JTextArea selectedModulesArea;
    private javax.swing.JLabel selectedModulesLabel;
    private javax.swing.JScrollPane selectedModulesPane;
    // End of variables declaration//GEN-END:variables
}
