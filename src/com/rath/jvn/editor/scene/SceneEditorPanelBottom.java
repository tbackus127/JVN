
package com.rath.jvn.editor.scene;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class SceneEditorPanelBottom extends JPanel {

  private static final long serialVersionUID = 1L;

  private SceneEditorQuotePanel quotePanel = null;

  public SceneEditorPanelBottom(final Dimension winSize) {
    super();
    setVisible(true);
    setLayout(new GridBagLayout());
    final GridBagConstraints gb = new GridBagConstraints();

    gb.fill = GridBagConstraints.BOTH;
    gb.anchor = GridBagConstraints.WEST;
    gb.weightx = 0.2D;
    gb.weighty = 1.0D;
    gb.gridx = 0;
    gb.gridy = 0;
    final SceneEditorCommandPanel cmdPanel = new SceneEditorCommandPanel(getSize());
    add(cmdPanel, gb);

    gb.gridx = 1;
    gb.weightx = 1.0D - gb.weightx;
    this.quotePanel = new SceneEditorQuotePanel("");
    add(this.quotePanel, gb);
  }
}
