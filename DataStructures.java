import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;
import java.io.File;
public class DataStructures {
	private static JButton sortInts = new JButton("sort ints");
	private static JLabel sortIntsTime = new JLabel("no result");
	private static JButton addBst = new JButton("add to bst");
	private static JLabel addBstTime = new JLabel("no result");
	private static JButton addTreeset = new JButton("add to treeset");
	private static JLabel addTreesetTime = new JLabel("no result");
	private static JButton addPrioQ = new JButton("add to priority queue");
	private static JLabel addPrioQTime = new JLabel("no result");
	private static JButton addHashset = new JButton("add to hashset");
	private static JLabel addHashsetTime = new JLabel("no result");
	private static JButton addArrList = new JButton("add to arraylist");
	private static JLabel addArrListTime = new JLabel("no result");
	private static JButton addSortArrList = new JButton("add to sorted arraylist");
	private static JLabel addSortArrListTime = new JLabel("no result");
	private static JButton addArr = new JButton("add to array");
	private static JLabel addArrTime = new JLabel("no result");
	private static JButton mergeSort1 = new JButton("merge sort ints bottom up");
    private static JLabel mergeSort1Time = new JLabel("no result");

	private static JButton searchInts = new JButton("search sorted ints");
	private static JLabel searchIntsTime = new JLabel("no result");
	private static JButton searchBst = new JButton("search bst");
	private static JLabel searchBstTime = new JLabel("no result");
	private static JButton searchTreeset = new JButton("search treeset");
	private static JLabel searchTreesetTime = new JLabel("no result");
	private static JButton searchPrioQ = new JButton("search priority queue");
	private static JLabel searchPrioQTime = new JLabel("no result");
	private static JButton searchHashset = new JButton("search hashset");
	private static JLabel searchHashsetTime = new JLabel("no result");
	private static JButton searchArrList = new JButton("search arraylist");
	private static JLabel searchArrListTime = new JLabel("no result");
	private static JButton searchSortArrList = new JButton("search sorted arraylist");
	private static JLabel searchSortArrListTime = new JLabel("no result");
	private static JButton searchArr = new JButton("search array");
	private static JLabel searchArrTime = new JLabel("no result");
	private static JButton searchMergeSort1 = new JButton("search merge sort ints bottom up");
    private static JLabel searchMergeSort1Time = new JLabel("no result");
	
	private static ArrayList<Integer> sortData = new ArrayList<>();
	private static ArrayList<Integer> searchData = new ArrayList<>();
	private static int[] sortDataArr;
	private static int[] searchDataArr;
	private static int[] sortedValues;
	private static TreeSet<Integer> treeSetValues = new TreeSet<>();
	private static HashSet<Integer> hashSetValues = new HashSet<>();
	private static PriorityQueue<Integer> prioQValues = new PriorityQueue<>();
	private static ArrayList<Integer> arrListValues = new ArrayList<>();
	private static ArrayList<Integer> sortArrListValues = new ArrayList<>();
	private static BinarySearchTree bst = new BinarySearchTree();
	private static int[] unsortedValues;
	private static int[] mergeSort1Values;
	private static boolean readSearchFile = false;
	public static void main(String[] args) {
		JFrame gui = new JFrame();
		gui.setPreferredSize(new Dimension(700, 350));
		gui.setMinimumSize(new Dimension(700, 350));
		gui.setMaximumSize(new Dimension(700, 350));
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem readSort = new JMenuItem("Read sort file");
		JMenuItem readSearch = new JMenuItem("Read search file");
		JMenuItem exit = new JMenuItem("Exit");
		
		MenuItemActionListener readSortListener = new MenuItemActionListener(readSort,args[0]);
		MenuItemActionListener readSearchListener = new MenuItemActionListener(readSearch,args[1]);
		MenuItemActionListener exitListener = new MenuItemActionListener(exit,null);
		
		readSort.addActionListener(readSortListener);
		readSearch.addActionListener(readSearchListener);
		exit.addActionListener(exitListener);
		
		menu.add(file);
		file.add(readSort);
		file.add(readSearch);
		file.add(exit);
		
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setBorder(new LineBorder(new Color(255,255,0,255), 2));
		leftButtonPanel.setPreferredSize(new Dimension(330,350));
		leftButtonPanel.setMinimumSize(new Dimension(330,350));
		GridBagLayout leftLayout = new GridBagLayout();
		leftButtonPanel.setLayout(leftLayout);
		
		leftButtonPanel.add(sortInts);
		sortInts.setEnabled(false);
		leftButtonPanel.add(sortIntsTime);
		leftButtonPanel.add(addBst);
		addBst.setEnabled(false);
		leftButtonPanel.add(addBstTime);
		leftButtonPanel.add(addTreeset);
		addTreeset.setEnabled(false);
		leftButtonPanel.add(addTreesetTime);
		leftButtonPanel.add(addPrioQ);
		addPrioQ.setEnabled(false);
		leftButtonPanel.add(addPrioQTime);
		leftButtonPanel.add(addHashset);
		addHashset.setEnabled(false);
		leftButtonPanel.add(addHashsetTime);
		leftButtonPanel.add(addArrList);
		addArrList.setEnabled(false);
		leftButtonPanel.add(addArrListTime);
		leftButtonPanel.add(addSortArrList);
		addSortArrList.setEnabled(false);
		leftButtonPanel.add(addSortArrListTime);
		leftButtonPanel.add(addArr);
		addArr.setEnabled(false);
		leftButtonPanel.add(addArrTime);
		leftButtonPanel.add(mergeSort1);
		mergeSort1.setEnabled(false);
		leftButtonPanel.add(mergeSort1Time);
		
		GridBagConstraints leftConstraints = new GridBagConstraints();
		leftConstraints.weightx = 1;
		leftConstraints.weighty = 1;
		leftConstraints.fill = GridBagConstraints.NONE;
		leftConstraints.anchor = GridBagConstraints.LINE_START;
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 0;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(sortInts, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 0;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(sortIntsTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 1;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addBst, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 1;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addBstTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 2;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addTreeset, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 2;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addTreesetTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 3;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addPrioQ, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 3;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addPrioQTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 4;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addHashset, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 4;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addHashsetTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 5;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addArrList, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 5;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addArrListTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 6;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addSortArrList, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 6;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addSortArrListTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 7;
		leftConstraints.gridwidth = 1;
		leftLayout.setConstraints(addArr, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 7;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(addArrTime, leftConstraints);
		leftConstraints.gridx = 0;
		leftConstraints.gridy = 8;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(mergeSort1, leftConstraints);
		leftConstraints.gridx = 1;
		leftConstraints.gridy = 8;
		leftConstraints.gridwidth = GridBagConstraints.REMAINDER;
		leftLayout.setConstraints(mergeSort1Time, leftConstraints);
		
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setBorder(new LineBorder(new Color(48,213,200,255), 2));
		rightButtonPanel.setPreferredSize(new Dimension(330,350));
		rightButtonPanel.setMinimumSize(new Dimension(330,350));
		GridBagLayout rightLayout = new GridBagLayout();
		rightButtonPanel.setLayout(rightLayout);
		
		rightButtonPanel.add(searchInts);
		searchInts.setEnabled(false);
		rightButtonPanel.add(searchIntsTime);
		rightButtonPanel.add(searchBst);
		searchBst.setEnabled(false);
		rightButtonPanel.add(searchBstTime);
		rightButtonPanel.add(searchTreeset);
		searchTreeset.setEnabled(false);
		rightButtonPanel.add(searchTreesetTime);
		rightButtonPanel.add(searchPrioQ);
		searchPrioQ.setEnabled(false);
		rightButtonPanel.add(searchPrioQTime);
		rightButtonPanel.add(searchHashset);
		searchHashset.setEnabled(false);
		rightButtonPanel.add(searchHashsetTime);
		rightButtonPanel.add(searchArrList);
		searchArrList.setEnabled(false);
		rightButtonPanel.add(searchArrListTime);
		rightButtonPanel.add(searchSortArrList);
		searchSortArrList.setEnabled(false);
		rightButtonPanel.add(searchSortArrListTime);
		rightButtonPanel.add(searchArr);
		searchArr.setEnabled(false);
		rightButtonPanel.add(searchArrTime);
		rightButtonPanel.add(searchMergeSort1);
		searchMergeSort1.setEnabled(false);
		rightButtonPanel.add(searchMergeSort1Time);

		GridBagConstraints rightConstraints = new GridBagConstraints();
		rightConstraints.weightx = 1;
		rightConstraints.weighty = 1;
		rightConstraints.fill = GridBagConstraints.NONE;
		rightConstraints.anchor = GridBagConstraints.LINE_START;
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 0;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchInts, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 0;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchIntsTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 1;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchBst, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 1;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchBstTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 2;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchTreeset, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 2;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchTreesetTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 3;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchPrioQ, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 3;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchPrioQTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 4;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchHashset, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 4;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchHashsetTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 5;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchArrList, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 5;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchArrListTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 6;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchSortArrList, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 6;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchSortArrListTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 7;
		rightConstraints.gridwidth = 1;
		rightLayout.setConstraints(searchArr, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 7;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchArrTime, rightConstraints);
		rightConstraints.gridx = 0;
		rightConstraints.gridy = 8;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchMergeSort1, rightConstraints);
		rightConstraints.gridx = 1;
		rightConstraints.gridy = 8;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightLayout.setConstraints(searchMergeSort1Time, rightConstraints);
		
		JPanel mainButtonPanel = new JPanel();
		mainButtonPanel.setBorder(new LineBorder(new Color(0,0,0,255), 2));
		BoxLayout mainButtonLayout = new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS);
		mainButtonPanel.setLayout(mainButtonLayout);
		mainButtonPanel.add(leftButtonPanel);
		mainButtonPanel.add(rightButtonPanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(255,0,0,255), 2));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(menu, BorderLayout.NORTH);
		mainPanel.add(mainButtonPanel, BorderLayout.CENTER);
		
		ButtonActionListener sortIntsListener = new ButtonActionListener(sortInts);
		ButtonActionListener addBstListener = new ButtonActionListener(addBst);
		ButtonActionListener addTreesetListener = new ButtonActionListener(addTreeset);
		ButtonActionListener addPrioQListener = new ButtonActionListener(addPrioQ);
		ButtonActionListener addHashsetListener = new ButtonActionListener(addHashset);
		ButtonActionListener addArrListListener = new ButtonActionListener(addArrList);
		ButtonActionListener addSortArrListListener = new ButtonActionListener(addSortArrList);
		ButtonActionListener addArrListener = new ButtonActionListener(addArr);
		ButtonActionListener mergeSort1Listener = new ButtonActionListener(mergeSort1);
		ButtonActionListener searchIntsListener = new ButtonActionListener(searchInts);
		ButtonActionListener searchBstListener = new ButtonActionListener(searchBst);
		ButtonActionListener searchTreesetListener = new ButtonActionListener(searchTreeset);
		ButtonActionListener searchPrioQListener = new ButtonActionListener(searchPrioQ);
		ButtonActionListener searchHashsetListener = new ButtonActionListener(searchHashset);
		ButtonActionListener searchArrListListener = new ButtonActionListener(searchArrList);
		ButtonActionListener searchSortArrListListener = new ButtonActionListener(searchSortArrList);
		ButtonActionListener searchArrListener = new ButtonActionListener(searchArr);
		ButtonActionListener searchMergeSort1Listener = new ButtonActionListener(searchMergeSort1);

		sortInts.addActionListener(sortIntsListener);
		addBst.addActionListener(addBstListener);
		addTreeset.addActionListener(addTreesetListener);
		addPrioQ.addActionListener(addPrioQListener);
		addHashset.addActionListener(addHashsetListener);
		addArrList.addActionListener(addArrListListener);
		addSortArrList.addActionListener(addSortArrListListener);
		addArr.addActionListener(addArrListener);
		mergeSort1.addActionListener(mergeSort1Listener);
		searchInts.addActionListener(searchIntsListener);
		searchBst.addActionListener(searchBstListener);
		searchTreeset.addActionListener(searchTreesetListener);
		searchPrioQ.addActionListener(searchPrioQListener);
		searchHashset.addActionListener(searchHashsetListener);
		searchArrList.addActionListener(searchArrListListener);
		searchSortArrList.addActionListener(searchSortArrListListener);
		searchArr.addActionListener(searchArrListener);
		searchMergeSort1.addActionListener(searchMergeSort1Listener);

		gui.setContentPane(mainPanel);
		gui.validate();
		gui.setVisible(true);
	}
	
	static class MenuItemActionListener implements ActionListener {
		private JMenuItem m;
		private String filename;
		MenuItemActionListener(JMenuItem m, String f) {
			this.m = m;
			filename = f;
		}
		public String getFileName() {
			return filename;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (m.getText().equals("Read sort file")) {
				File file = new File(getFileName());
				try {
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						sortData.add(Integer.parseInt(line));
					}
					sortDataArr = sortData.stream().mapToInt(x -> x).toArray();
					sortInts.setEnabled(true);
					addBst.setEnabled(true);
					addTreeset.setEnabled(true);
					addPrioQ.setEnabled(true);
					addHashset.setEnabled(true);
					addArrList.setEnabled(true);
					addSortArrList.setEnabled(true);
					addArr.setEnabled(true);
					mergeSort1.setEnabled(true);
				} catch (Exception a) {}
			}
			if (m.getText().equals("Read search file")) {
				File file = new File(getFileName());
				try {
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						searchData.add(Integer.parseInt(line));
					}
					searchDataArr = searchData.stream().mapToInt(x -> x).toArray();
					readSearchFile = true;
					if (!sortIntsTime.getText().equals("no result")) searchInts.setEnabled(true);
					if (!addBstTime.getText().equals("no result")) searchBst.setEnabled(true);
					if (!addTreesetTime.getText().equals("no result")) searchTreeset.setEnabled(true);
					if (!addPrioQTime.getText().equals("no result")) searchPrioQ.setEnabled(true);
					if (!addHashsetTime.getText().equals("no result")) searchHashset.setEnabled(true);
					if (!addArrListTime.getText().equals("no result")) searchArrList.setEnabled(true);
					if (!addSortArrListTime.getText().equals("no result")) searchSortArrList.setEnabled(true);
					if (!addArrTime.getText().equals("no result")) searchArr.setEnabled(true);
					if (!mergeSort1Time.getText().equals("no result")) searchMergeSort1.setEnabled(true);
				} catch (Exception a) {}
			}
			if (m.getText().equals("Exit")) {
				System.exit(0);
			}
		}
	}
	
	static class ButtonActionListener implements ActionListener {
		private JButton b; 
		ButtonActionListener(JButton b) {
			this.b = b;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = b.getText();
			switch (button) {
				case "sort ints":
					selectionSort();
					if (readSearchFile) searchInts.setEnabled(true);
					break;
				case "add to bst":
					addToBinarySearchTree();
					if (readSearchFile) searchBst.setEnabled(true);
					break;
				case "add to treeset":
					addToTreeSet();
					if (readSearchFile) searchTreeset.setEnabled(true);
					break;
				case "add to priority queue":
					addToPriorityQueue();
					if (readSearchFile) searchPrioQ.setEnabled(true);
					break;
				case "add to hashset":
					addToHashSet();
					if (readSearchFile) searchHashset.setEnabled(true);
					break;
				case "add to arraylist":
					addToArrayList();
					if (readSearchFile) searchArrList.setEnabled(true);
					break;
				case "add to sorted arraylist":
					addToSortedArrayList();
					if (readSearchFile) searchSortArrList.setEnabled(true);
					break;
				case "add to array":
					addToArray();
					if (readSearchFile) searchArr.setEnabled(true);
					break;
				case "merge sort ints bottom up":
					botUpMergeSort(mergeSort1Values);
					if (readSearchFile) searchMergeSort1.setEnabled(true);
					break;
				case "search sorted ints":
					searchInts(sortedValues,searchIntsTime);
					break;
				case "search bst":
					searchBinarySearchTree();
					break;
				case "search treeset":
					searchTreeSet();
					break;
				case "search priority queue":
					searchPriorityQueue();
					break;
				case "search hashset":
					searchHashSet();
					break;
				case "search arraylist":
					searchArrayList();
					break;
				case "search sorted arraylist":
					searchSortedArrayList();
					break;
				case "search array":
					searchArray();
					break;
				case "search merge sort ints bottom up":
					searchInts(mergeSort1Values,searchMergeSort1Time);
					break;
			}
		}
	}
	
	private static void selectionSort() {
		long t0 = System.currentTimeMillis();
		sortedValues = new int[sortDataArr.length];
		for (int i = 0; i < sortDataArr.length; i++) {
			sortedValues[i] = sortDataArr[i];
		}
		for (int i = 0; i < sortedValues.length - 1; i++ ) {
			int minIdx = i;
			for (int j = i+1; j < sortedValues.length; j++) {
				if (sortedValues[j] < sortedValues[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = sortedValues[minIdx];
			sortedValues[minIdx] = sortedValues[i];
			sortedValues[i] = tmp;
		}
		long t1 = System.currentTimeMillis();
		sortIntsTime.setText((t1-t0) + "ms");
	}
	private static void addToBinarySearchTree() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < sortDataArr.length; i++) {
			bst.insertNode(new Node(sortDataArr[i]));
		}
		long t1 = System.currentTimeMillis();
		addBstTime.setText((t1-t0) + "ms");
	}
	private static void addToTreeSet() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < sortDataArr.length; i++) {
			treeSetValues.add(sortDataArr[i]);
		}
		long t1 = System.currentTimeMillis();
		addTreesetTime.setText((t1-t0) + "ms");
	}
	private static void addToPriorityQueue() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < sortDataArr.length; i++) {
			prioQValues.add(sortDataArr[i]);
		}
		long t1 = System.currentTimeMillis();
		addPrioQTime.setText((t1-t0) + "ms");
	}
	private static void addToHashSet() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < sortDataArr.length; i++) {
			hashSetValues.add(sortDataArr[i]);
		}
		long t1 = System.currentTimeMillis();
		addHashsetTime.setText((t1-t0) + "ms");
	}
	private static void addToArrayList() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < sortDataArr.length; i++) {
			arrListValues.add(sortDataArr[i]);
		}
		long t1 = System.currentTimeMillis();
		addArrListTime.setText((t1-t0) + "ms");
	}
	private static void addToSortedArrayList() {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < sortDataArr.length; i++) {
			sortArrListValues.add(sortDataArr[i]);
		}
		sortArrListValues = sortArrListValues.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		long t1 = System.currentTimeMillis();
		addSortArrListTime.setText((t1-t0) + "ms");
	}
	private static void addToArray() {
		long t0 = System.currentTimeMillis();
		unsortedValues = new int[sortDataArr.length];
		for (int i = 0; i < sortDataArr.length; i++) {
			unsortedValues[i] = sortDataArr[i];
		}
		long t1 = System.currentTimeMillis();
		addArrTime.setText((t1-t0) + "ms");
	}
	private static void botUpMergeSort(int[] arr) {
		arr = Arrays.copyOf(sortDataArr, sortDataArr.length);
		long t0 = System.currentTimeMillis();
		int[] workArr =  Arrays.copyOf(arr, arr.length);
		for (int width = 1; width < arr.length; width = 2*width) {
			for (int i = 0;  i < arr.length; i = i + 2*width) {
				int left = i;
				int mid = Math.min(i + width,arr.length);
				int end = Math.min(i + 2*width,arr.length);
				botUpMerge(arr,left,mid,end,workArr);
			}
			arr = Arrays.copyOf(workArr, workArr.length);
		}
		long t1 = System.currentTimeMillis();
		mergeSort1Values = Arrays.copyOf(arr, arr.length);
		mergeSort1Time.setText((t1-t0) + "ms");
	}
	private static void botUpMerge(int[] arrA, int left, int mid, int end, int[] arrB) {
		int i = left, j = mid;
		for (int k = left; k < end; k++) {
			if ((i < mid) && ((j >= end) || (arrA[i] <= arrA[j]))) {
				arrB[k] = arrA[i];
				i++;
			} else {
				arrB[k] = arrA[j];
				j++;
			}
		}
	}
	private static int searchInts(int[] arr, JLabel label) {
		long t0 = System.currentTimeMillis();
		int count = 0; 
		for (int i = 0; i < searchDataArr.length; i++) {
			int val = searchDataArr[i];
			int bot = 0;
			int top = arr.length - 1;
			while (bot <= top) {
				int mid = (top + bot)/2;
				if (val < arr[mid]) {
					top = mid - 1;
				} else if (val > arr[mid]) {
					bot = mid + 1;
				} else {
					count++;
					break;
				}
			}
		}
		long t1 = System.currentTimeMillis();
		label.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchBinarySearchTree() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			if (bst.getNode(bst.getRoot(), searchDataArr[i]) != null) count++;
		}
		long t1 = System.currentTimeMillis();
		searchBstTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchTreeSet() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			if (treeSetValues.contains(searchDataArr[i])) count++;
		}
		long t1= System.currentTimeMillis();
		searchTreesetTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchPriorityQueue() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			if (prioQValues.contains(searchDataArr[i])) count++;
		}
		long t1= System.currentTimeMillis();
		searchPrioQTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchHashSet() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			if (hashSetValues.contains(searchDataArr[i])) count++;
		}
		long t1= System.currentTimeMillis();
		searchHashsetTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchArrayList() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			if (arrListValues.contains(searchDataArr[i])) count++;
		}
		long t1= System.currentTimeMillis();
		searchArrListTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchSortedArrayList() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			int val = searchDataArr[i];
			int bot = 0;
			int top = sortArrListValues.size()-1;
			while (bot <= top) {
				int mid = (top + bot) / 2;
				if (val < sortArrListValues.get(mid)) {
					top = mid - 1;
				} else if (val > sortArrListValues.get(mid)) {
					bot = mid + 1;
				} else {
					count++;
					break;
				}
			}
		}
		long t1= System.currentTimeMillis();
		searchSortArrListTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
	private static int searchArray() {
		long t0 = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < searchDataArr.length; i++) {
			for (int j = 0; j < unsortedValues.length; j++) {
				if (searchDataArr[i] == unsortedValues[j]) {
					count++;
					break;
				}
			}
		}
		long t1 = System.currentTimeMillis();
		searchArrTime.setText(count + " / " + (t1-t0) + "ms");
		return count;
	}
}