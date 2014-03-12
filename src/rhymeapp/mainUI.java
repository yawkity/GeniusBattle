/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * mainUI.java
 *
 * Created on Jul 23, 2009, 5:09:27 PM
 */

package rhymeapp;

/**
 *
 * @author Hussein
 */

import backend.*;

import java.awt.Color;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.Classifier;

public class mainUI extends javax.swing.JFrame {

    public static final String INSTANCES_FILE = "rhymeFeatures25.arff";
    public static final String MODEL_FILE = "rhymeFeatures25.model";
    //public static final String STATS_FILE = "lib/iterationStatsUF.txt";
    public static final String STATS_FILE = "iterationStatsUF.txt";

    Transcriptor tr;
    Stats st;
    Scoring sc;
    Detector det;
    Instances dataSet;
    Classifier cl;
    Classification classon;

    SimpleAttributeSet[] attributes = new SimpleAttributeSet[5];


    /** Creates new form mainUI */
    public mainUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error setting Look-And-Feel: " + e.getMessage());
        }
        initComponents();
        this.setTitle("Rhyme Analyzer 1.0");
        btnTranscribe.setEnabled(false);
        btnAnalyze.setEnabled(false);
        btnShowRhymes.setEnabled(false);
        for (int i=0; i<attributes.length; i++) {
            attributes[i] = new SimpleAttributeSet();
        }
        StyleConstants.setBold(attributes[0], true);
        StyleConstants.setItalic(attributes[1], true);
        //StyleConstants.setFontFamily(attributes[2], "Serif");
        StyleConstants.setForeground(attributes[2], Color.red);
        StyleConstants.setUnderline(attributes[3], true);
        StyleConstants.setStrikeThrough(attributes[4], true);

        try {
            st = new Stats(STATS_FILE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error opening Stats file: " + e.getMessage());
        }

        try {
            tr = new Transcriptor();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating Transcriptor: " + e.getMessage());
        }

        classon = new Classification();
        try {
            cl = classon.readClassifier(MODEL_FILE);
            dataSet = classon.readInstances(INSTANCES_FILE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading in classifier: " + e.toString());
        }

        sc = new Scoring(st, Stats.SPLIT);
        det = new Detector(sc);

        btnTranscribe.setEnabled(true);
        btnAnalyze.setEnabled(true);
        btnShowRhymes.setEnabled(true);


    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        btnLoad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextPane();
        btnTranscribe = new javax.swing.JButton();
        btnShowRhymes = new javax.swing.JButton();
        btnAnalyze = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();
        btnClassify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtInput.setColumns(20);
        txtInput.setFont(new java.awt.Font("Arial", 0, 16));
        txtInput.setRows(5);
        jScrollPane1.setViewportView(txtInput);

        btnLoad.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnLoad.setText("Load from text file");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        txtOutput.setFont(new java.awt.Font("Arial", 0, 16));
        jScrollPane2.setViewportView(txtOutput);

        btnTranscribe.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnTranscribe.setText("Transcribe Phonetically");
        btnTranscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranscribeActionPerformed(evt);
            }
        });

        btnShowRhymes.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnShowRhymes.setText("Show Rhymes");
        btnShowRhymes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRhymesActionPerformed(evt);
            }
        });

        btnAnalyze.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnAnalyze.setText("Analyze Rhymes");
        btnAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyzeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel1.setText("Input Lyrics");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel2.setText("Output");

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnScore.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnScore.setText("Score Lines");
        btnScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreActionPerformed(evt);
            }
        });

        btnClassify.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnClassify.setText("Classify Rapper");
        btnClassify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addComponent(btnShowRhymes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnalyze)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClassify))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLoad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTranscribe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLoad)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTranscribe)
                    .addComponent(btnScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClassify)
                        .addComponent(btnAnalyze)
                        .addComponent(btnShowRhymes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        JFileChooser chooser = new JFileChooser(  );
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.CANCEL_OPTION) return;
		try {
			File file = chooser.getSelectedFile();
                        BufferedReader fi = new BufferedReader(new FileReader(file));
                        txtInput.setText("");
                        while (fi.ready()) {
                            txtInput.append(fi.readLine() + "\n");
                        }
                        //JOptionPane.showMessageDialog(this, "Done reading from file.");

		} catch (Exception e) { }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnTranscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranscribeActionPerformed
        String[] inLines = txtInput.getText().split("\n");
        String outLine = "";
        txtOutput.setText("");
        for (int i=0; i<inLines.length; i++) {
            // change this after adding transcriptor
            outLine = tr.transcribe(inLines[i]).toString() + "\n";
            try {
                Document d = txtOutput.getDocument();
                d.insertString(d.getLength(), outLine, new SimpleAttributeSet());
                txtOutput.setDocument(d);
            } catch (Exception ble) {
                JOptionPane.showMessageDialog(this, "Error writing to document." + ble.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnTranscribeActionPerformed

    private void btnAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyzeActionPerformed
        String[] plainLines = txtInput.getText().split("\n");
        if (plainLines.length<2) return;
        ArrayList<PLine> inLines = new ArrayList<PLine>();
        for (int i=0; i<plainLines.length; i++) {
            inLines.add(tr.transcribe(plainLines[i]));
        }
        Analyzer an = new Analyzer("Input Lines", sc);
        String outLine = "";
        RhymeCollection rc = det.getRhymes(inLines);
        rc.lines = inLines;
        if (!an.addRhymes(rc)) {
            JOptionPane.showMessageDialog(this, "Could not add rhymes to Analyzer.");
        } else {
            Analysis anOut = an.createAnalysis();
            outLine = anOut.toString();
        }
        txtOutput.setCharacterAttributes(new SimpleAttributeSet(), true);
        txtOutput.setText(outLine);
    }//GEN-LAST:event_btnAnalyzeActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtInput.setText("");
        txtOutput.setCharacterAttributes(new SimpleAttributeSet(), true);
        txtOutput.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnShowRhymesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRhymesActionPerformed
        String[] plainLines = txtInput.getText().split("\n");
        ArrayList<PLine> inLines = new ArrayList<PLine>();
        for (int i=0; i<plainLines.length; i++) {
            inLines.add(tr.transcribe(plainLines[i]));
        }
        RhymeCollection rc = det.getRhymes(inLines);
        rc.lines = inLines;
        if (inLines.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No lines in input text.");
            return;
        }
        txtOutput.setText("");
        int styleMod = 0;
        SimpleAttributeSet[] curLine = new SimpleAttributeSet[0];
        SimpleAttributeSet[] nextLine = new SimpleAttributeSet[rc.lines.get(0).size()];
        for (int i=0; i<nextLine.length; i++) {
            nextLine[i] = new SimpleAttributeSet();
        }

        for (int i=0; i<rc.lines.size(); i++) {
            curLine = nextLine;
            if (rc.lines.size()>i+1) {
                nextLine = new SimpleAttributeSet[rc.lines.get(i+1).size()];
                for (int j=0; j<nextLine.length; j++) {
                    nextLine[j] = new SimpleAttributeSet();
                }
            }
            ArrayList<Rhyme> curLineRhymes = rc.collection[i];

            for (int j=0; j<curLineRhymes.size(); j++) {
                Rhyme r = curLineRhymes.get(j);
                int firstWord = wordIndex(rc.lines.get(i),r.aStart.syllable);
                int lastWord = wordIndex(rc.lines.get(i),r.aEnd().syllable);
                for (int k=firstWord; k<=lastWord; k++) {
                    curLine[k].addAttributes(attributes[styleMod]);
                }
                if (r.aStart.sameLine(r.bStart)) {
                    firstWord = wordIndex(rc.lines.get(i),r.bStart.syllable);
                    lastWord = wordIndex(rc.lines.get(i), r.bEnd().syllable);
                    for (int k=firstWord; k<=lastWord; k++) {
                        curLine[k].addAttributes(attributes[styleMod]);
                    }
                } else {
                    firstWord = wordIndex(rc.lines.get(i+1),r.bStart.syllable);
                    lastWord = wordIndex(rc.lines.get(i+1),r.bEnd().syllable);
                    for (int k=firstWord; k<=lastWord; k++) {
                        nextLine[k].addAttributes(attributes[styleMod]);
                    }
                }
                styleMod = (styleMod + 1) % attributes.length;
            }
            //JOptionPane.showMessageDialog(this, "Trying to write to document.");
            try {
                Document d = txtOutput.getDocument();
                for (int k=0; k<curLine.length; k++) {
                    d.insertString(d.getLength(), rc.lines.get(i).get(k).getPlainWord() + " ", curLine[k]);
                }
                d.insertString(d.getLength(), "\n", new SimpleAttributeSet());
                txtOutput.setDocument(d);
            } catch (Exception ble) {
                JOptionPane.showMessageDialog(this, "Error writing to document." + ble.getMessage());
            }

        }
        
        //JOptionPane.showMessageDialog(this, "Done trying to write to document.");
    }//GEN-LAST:event_btnShowRhymesActionPerformed

    private void btnScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreActionPerformed
        txtOutput.setCharacterAttributes(new SimpleAttributeSet(), true);
        txtOutput.setText("");
        
        String[] plainLines = txtInput.getText().split("\n");
        String outLine = "";

        for (int i=1; i<plainLines.length; i++) {
            PLine a = tr.transcribe(plainLines[i-1]);
            PLine b = tr.transcribe(plainLines[i]);
            double[] scores = sc.scoreRhyme(a, b, "iteration");
            for (int j=0; j<scores.length; j++) {
                    outLine += (scores[j] + " ");
            }
            outLine += "\n";
        }
        txtOutput.setText(outLine);

    }//GEN-LAST:event_btnScoreActionPerformed

    private void btnClassifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassifyActionPerformed
        String[] plainLines = txtInput.getText().split("\n");
        txtOutput.setCharacterAttributes(new SimpleAttributeSet(), true);

        if (plainLines.length<2) {
            txtOutput.setText("Not enough data to guess rapper.");
            return;
        }

        ArrayList<PLine> inLines = new ArrayList<PLine>();
        for (int i=0; i<plainLines.length; i++) {
            inLines.add(tr.transcribe(plainLines[i]));
        }

        Instance inst;
        try {
            inst = classon.getRhymeInstance(inLines, sc, det);
        } catch (Exception e) {
            txtOutput.setText("Error creating rhyme analysis instance: " + e.toString());
            return;
        }

        if (inst == null) {
            txtOutput.setText("Not enough rhyme data to perform classification.");
            return;
        }

        inst.setDataset(dataSet);
        try {
            txtOutput.setText("The rhyming style is most similar to " + classon.getClass(cl, inst));
        } catch (Exception e) {
            txtOutput.setText("Error performing classification: " + e.toString());
        }
    }//GEN-LAST:event_btnClassifyActionPerformed

    private int wordIndex(PLine pl, int sylIndex) {
        int ret = -1;
        int sylLoc = -1;
        while (sylLoc<sylIndex) {
            ret++;
            sylLoc += pl.get(ret).numSyls();
        }
        return ret;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        if ( args.length > 0 ) {
            try {
				System.exit((new cmdLineApp()).run(args));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new mainUI().setVisible(true);
                }
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyze;
    private javax.swing.JButton btnClassify;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnScore;
    private javax.swing.JButton btnShowRhymes;
    private javax.swing.JButton btnTranscribe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JTextPane txtOutput;
    // End of variables declaration//GEN-END:variables

}