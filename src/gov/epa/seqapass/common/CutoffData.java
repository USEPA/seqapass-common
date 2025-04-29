package gov.epa.seqapass.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;

//
//import gov.epa.seqapass.controller.ReportController;

public class CutoffData implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3031773747034477920L;
  private List<Double> xData;
  private List<Double> yData;
  private List<Double> cutoffValues;
  private List<Integer> maxCritLoc;
  private List<Integer> minCritLoc;
  private List<Integer> infLoc;

  public CutoffData() {
  }

  public CutoffData(List<Double> xData, List<Double> yData, List<Double> cutoffValues, List<Integer> maxCritLoc,
      List<Integer> minCritLoc, List<Integer> infLoc) {
    this.xData = xData;
    this.yData = yData;
    this.cutoffValues = cutoffValues;
    this.maxCritLoc = maxCritLoc;
    this.minCritLoc = minCritLoc;
    this.infLoc = infLoc;
  }

  /**
   * Static factory method for CutoffData
   * 
   * @param densityData
   *          - List of DensityRow objects
   * @return CutoffData object or null(if cutoff calculations cannot be performed)
   */
  public static CutoffData newInstance(List<DensityRow> densityData, int level) {
	CutoffData temp = null;
	if (level == 1 || level == 2) {
		temp = new CutoffData(densityData);
	} else {
		//L4
		temp = new CutoffData(densityData, 4);
	}
    if (temp == null || temp.xData == null) {
      return null;
    }
    return temp;
  }

  public CutoffData(List<DensityRow> densityData) {
    CutoffData temp = calcCutoff(densityData);

    // Constructor cannot return null object
    // The code below gives a way for the static factory method above to
    // return null if needed
    if (temp != null) {
      this.xData = temp.xData;
      this.yData = temp.yData;
      this.cutoffValues = temp.cutoffValues;
      this.maxCritLoc = temp.maxCritLoc;
      this.minCritLoc = temp.minCritLoc;
      this.infLoc = temp.infLoc;
    } else {
      this.xData = null;
      this.yData = null;
      this.cutoffValues = null;
      this.maxCritLoc = null;
      this.minCritLoc = null;
      this.infLoc = null;
    }
  }
  
  public CutoffData(List<DensityRow> densityData, int level) {
	  	CutoffData temp = null;
	  	if (level == 4 ) {
	      temp = calcL4Cutoff(densityData);
	  	}

	    // Constructor cannot return null object
	    // The code below gives a way for the static factory method above to
	    // return null if needed
	    if (temp != null) {
	      this.xData = temp.xData;
	      this.yData = temp.yData;
	      this.cutoffValues = temp.cutoffValues;
	      this.maxCritLoc = temp.maxCritLoc;
	      this.minCritLoc = temp.minCritLoc;
	      this.infLoc = temp.infLoc;
	    } else {
	      this.xData = null;
	      this.yData = null;
	      this.cutoffValues = null;
	      this.maxCritLoc = null;
	      this.minCritLoc = null;
	      this.infLoc = null;
	    }
	  }

  // public CutoffData(List<DensityRow> densityData) {
  // CutoffData temp = calcCutoff(densityData);
  //
  // if (temp != null) {
  //
  // this.xData = temp.xData;
  // this.yData = temp.yData;
  // this.cutoffValues = temp.cutoffValues;
  // this.maxCritLoc = temp.maxCritLoc;
  // this.minCritLoc = temp.minCritLoc;
  // this.infLoc = temp.infLoc;
  // } else {
  // this.xData = null;
  // this.yData = null;
  // this.cutoffValues = null;
  // this.maxCritLoc = null;
  // this.minCritLoc = null;
  // this.infLoc = null;
  // }
  //
  // }

  @Override
  public String toString() {
    return "CutoffData [xData=" + xData.toString() + ", yData=" + yData.toString() + ", cutoffValues="
        + cutoffValues.toString() + ", maxCritLoc=" + maxCritLoc + ", minCritLoc=" + minCritLoc + "infLoc=" + infLoc
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + xData.toString().hashCode();
    result = prime * result + yData.toString().hashCode();
    result = prime * result + cutoffValues.toString().hashCode();
    result = prime * result + maxCritLoc.toString().hashCode();
    result = prime * result + minCritLoc.toString().hashCode();
    result = prime * result + infLoc.toString().hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CutoffData other = (CutoffData) obj;
    if (xData == null) {
      if (other.xData != null)
        return false;
    } else if (!xData.equals(other.xData))
      return false;
    if (yData == null) {
      if (other.yData != null)
        return false;
    } else if (!yData.equals(other.yData))
      return false;
    if (cutoffValues == null) {
      if (other.cutoffValues != null)
        return false;
    } else if (!cutoffValues.equals(other.cutoffValues))
      return false;
    if (maxCritLoc == null) {
      if (other.maxCritLoc != null)
        return false;
    } else if (!maxCritLoc.equals(other.maxCritLoc))
      return false;
    if (minCritLoc == null) {
      if (other.minCritLoc != null)
        return false;
    } else if (!minCritLoc.equals(other.minCritLoc))
      return false;
    if (infLoc == null) {
      if (other.infLoc != null)
        return false;
    } else if (!infLoc.equals(other.infLoc))
      return false;
    return true;
  }

  /**
   * Performs cutoff calculations for given density data
   * 
   * @param densityData
   *          - List of DensityRow objects
   * @return CutoffData object
   */
  public CutoffData calcCutoff(List<DensityRow> densityData) {
    if (densityData == null) {
      System.out.println("densityData is null....returning null cutoff");
      return null;
    }
    if (densityData.size() < 3) {
      System.out.println("densityData size < 3....returning null cutoff");
      return null;
    }
    List<Double> simData = new ArrayList<Double>();
    List<String> orthoData = new ArrayList<String>();
    CutoffData cutoffData = new CutoffData();

    // prepare density data for cutoff calculations
    for (DensityRow row : densityData) {
      if (row.getPercSim() < 0.0) {
        System.out.println("Percent Similarity contains a negative number....returning null cutoff");
        return null;
      } else if (row.getPercSim() > 1.0) {
        simData.add(100.0);
      } else {
        simData.add(row.getPercSim() * 100.0);
      }
      orthoData.add(row.getOrtholog());
    }

    boolean orthologs = false;
    if (simData.size() == 0) {
      System.out.println("Invalid Percent Similarity Data!....returning null cutoff");
      return null;
    }
    if (orthoData.size() == 0) {
      System.out.println("Invalid Ortholog Data!....returning null cutoff");
      return null;
    }
    // remove first row so not comparing to self
    simData.remove(0);
    orthoData.remove(0);
    // check for orthologs
    if (orthoData.toString().toLowerCase().contains("y")) {
      orthologs = true;
    }

    Double[] valueArray = new Double[simData.size()];
    valueArray = simData.toArray(valueArray);
    double[] values = Arrays.stream(valueArray).mapToDouble(Double::doubleValue).toArray(); // convert
    // to
    // primitive
    StandardDeviation stdDevObj = new StandardDeviation();
    double stdDev = stdDevObj.evaluate(values);
    // double bandwidth = Math.pow((4.0 * Math.pow(stdDev, 5) / (3.0 *
    // simData.size())), 1.0 / 5.0); // silverman's rule of thumb
    double iqr = iqr(values);

    System.out.println("IQR = " + iqr);
    System.out.println("stdDev = " + stdDev);
    double bandwidth = 0.9 * Math.min(stdDev, iqr / 1.34) / Math.pow(simData.size(), 1.0 / 5.0); // silverman's
    // rule
    // of
    // thumb
    List<Double> xVals = new ArrayList<Double>();
    int numPoints = 100;
    for (int i = 0; i <= numPoints; i++) {
      xVals.add((double) i * 100.0 / numPoints);
    }

    System.out.println("bandwidth = " + bandwidth);

    List<Double> res = new ArrayList<Double>();

    for (int i = 0; i < xVals.size(); i++) { // index iterates over xVals
      double tmp = 0;
      for (int j = 0; j < simData.size(); j++) { // index iterates over
        // data
        double kernel = gaussianKernel(xVals.get(i) - simData.get(j), bandwidth);
        // double kernel = epanechnikovKernel(xVals.get(i) - simData.get(j), bandwidth);
        tmp += kernel;
      }
      tmp /= simData.size();
      res.add(tmp * 100);
    }

    cutoffData.xData = xVals;
    cutoffData.yData = res;

    // for (int i = 0; i < cutoffData.xData.size(); i++) {
    // System.out.println(cutoffData.xData.get(i) + "," +
    // cutoffData.yData.get(i));
    // }

    List<Double> firstDeriv = new ArrayList<Double>();
    List<Double> secondDeriv = new ArrayList<Double>();

    for (int i = 0; i < res.size() - 1; i++) {
      firstDeriv.add((res.get(i + 1) - res.get(i)) / (xVals.get(i + 1) - xVals.get(i)));
    }

    for (int i = 0; i < firstDeriv.size() - 1; i++) {
      secondDeriv.add((firstDeriv.get(i + 1) - firstDeriv.get(i)) / (xVals.get(i + 2) - xVals.get(i + 1)));
    }

    List<Double> changing = new ArrayList<Double>();

    for (int i = 0; i < firstDeriv.size() - 1; i++) {
      changing.add(firstDeriv.get(i) * firstDeriv.get(i + 1));
    }
    changing.add(0.0); // add 0 to end of list for 99th value

    List<Integer> criticalPoints = new ArrayList<Integer>();
    for (int i = 0; i < changing.size(); i++) {
      if (changing.get(i) <= 0.0) {
        criticalPoints.add(i);
      }
    }

    cutoffData.minCritLoc = new ArrayList<Integer>();
    cutoffData.maxCritLoc = new ArrayList<Integer>();
    cutoffData.infLoc = new ArrayList<Integer>();
    cutoffData.cutoffValues = new ArrayList<Double>();
    for (int i = 0; i < criticalPoints.size(); i++) {
      Integer tmpLoc = criticalPoints.get(i);
      if (tmpLoc < secondDeriv.size()) {
        if (secondDeriv.get(tmpLoc) < 0.0) {
          if (res.get(tmpLoc) > res.get(tmpLoc + 1)) {
            cutoffData.maxCritLoc.add(tmpLoc);
          } else {
            cutoffData.maxCritLoc.add(tmpLoc + 1);
          }
        } else if (secondDeriv.get(tmpLoc) > 0.0) {
          if (res.get(tmpLoc) < res.get(tmpLoc + 1)) {
            cutoffData.minCritLoc.add(tmpLoc);
          } else {
            cutoffData.minCritLoc.add(tmpLoc + 1);
          }
        } else {
          cutoffData.infLoc.add(tmpLoc);
        }
      }
    }

    List<Integer> LUB = new ArrayList<Integer>();

    if (orthologs) {
      List<Integer> tmpLoc1 = new ArrayList<Integer>();
      for (int i = 0; i < cutoffData.minCritLoc.size(); i++) {
        tmpLoc1.clear();
        Integer minPoint = cutoffData.minCritLoc.get(i);
        for (int j = 0; j < simData.size(); j++) {
          if (simData.get(j) >= xVals.get(minPoint) && orthoData.get(j).equals("Y")) {
            tmpLoc1.add(j);
          }
        }

        if (tmpLoc1.size() > 0) {
          // This gets the max value (index location) because data is
          // arranged from largest to smallest
          // so, this results in getting the value greater than but
          // closest to the xVal that is also an ortholog
          int loc = Collections.max(tmpLoc1);
          if (!LUB.contains(loc)) {
            LUB.add(Collections.max(tmpLoc1));
          }
        }
      }
      for (int i = 0; i < LUB.size(); i++) {
        cutoffData.cutoffValues.add(simData.get(LUB.get(i)));
      }

    } else {
      System.out.println("Calculating cutoffs without orthologs");
      for (int i = 0; i < cutoffData.minCritLoc.size(); i++) {
        Integer minPoint = cutoffData.minCritLoc.get(i);
        cutoffData.cutoffValues.add(xVals.get(minPoint));
      }
    }

    if (cutoffData.cutoffValues.size() == 0) {
      System.out.println("No cutoff values found, probably due to no orthologs after minimum");
      System.out.println("setting cutoff value to 100");
      cutoffData.cutoffValues.add(100.0);
    }

    System.out.println("finished cutoff calculations");
    return cutoffData;
  }
  
  
  /**
   * Performs cutoff calculations for given density data
   * 
   * @param densityData
   *          - List of DensityRow objects
   * @return CutoffData object
   */
  public CutoffData calcL4Cutoff(List<DensityRow> densityData) {
    if (densityData == null) {
      System.out.println("L4 densityData is null....returning null cutoff");
      return null;
    }
//    if (densityData.size() < 3) {
//      System.out.println("densityData size < 3....returning null cutoff");
//      return null;
//    }
    List<Double> simData = new ArrayList<Double>();
//    List<String> orthoData = new ArrayList<String>();
    CutoffData cutoffData = new CutoffData();

    // prepare density data for cutoff calculations
    //Note: PercSim contains absolute length for level 4 data
    for (DensityRow row : densityData) {
      if (row.getPercSim() < 0.0) {
        System.out.println("Absolute Length contains a negative number....returning null cutoff");
        return null;
      } else if (row.getPercSim() > 100.0) {
        simData.add(100.0);
      } else {
        simData.add(row.getPercSim()*100.0);
      }
    }
    
//    // prepare density data for cutoff calculations
//    for (DensityRow row : densityData) {
//      if (row.getPercSim() < 0.0) {
//        System.out.println("Percent Similarity contains a negative number....returning null cutoff");
//        return null;
//      } else if (row.getPercSim() > 1.0) {
//        simData.add(100.0);
//      } else {
//        simData.add(row.getPercSim() * 100.0);
//      }
////      orthoData.add(row.getOrtholog());
//    }

//    boolean orthologs = false;
    if (simData.size() == 0) {
      System.out.println("Invalid Percent Similarity Data!....returning null cutoff");
      return null;
    }
//    if (orthoData.size() == 0) {
//      System.out.println("Invalid Ortholog Data!....returning null cutoff");
//      return null;
//    }
//    // remove first row so not comparing to self
//    simData.remove(0);
//    orthoData.remove(0);
//    // check for orthologs
//    if (orthoData.toString().toLowerCase().contains("y")) {
//      orthologs = true;
//    }

    Double[] valueArray = new Double[simData.size()];
    valueArray = simData.toArray(valueArray);
    double[] values = Arrays.stream(valueArray).mapToDouble(Double::doubleValue).toArray(); // convert
    // to
    // primitive
    StandardDeviation stdDevObj = new StandardDeviation();
    double stdDev = stdDevObj.evaluate(values);
    // double bandwidth = Math.pow((4.0 * Math.pow(stdDev, 5) / (3.0 *
    // simData.size())), 1.0 / 5.0); // silverman's rule of thumb
    double iqr = iqr(values);

    System.out.println("IQR = " + iqr);
    System.out.println("stdDev = " + stdDev);
    double bandwidth = 0.9 * Math.min(stdDev, iqr / 1.34) / Math.pow(simData.size(), 1.0 / 5.0); // silverman's
    // rule
    // of
    // thumb
    List<Double> xVals = new ArrayList<Double>();
    int numPoints = 100;
    for (int i = 0; i <= numPoints; i++) {
      xVals.add((double) i * 100.0 / numPoints);
    }

    System.out.println("bandwidth = " + bandwidth);
    
    //adjust bandwidth so kernel can be generated in case all values are at single point.
    boolean forceCutoff = false;
    if (bandwidth == 0.0) {
    	bandwidth = 1.0;
    	forceCutoff = true;
    }

    List<Double> res = new ArrayList<Double>();

    for (int i = 0; i < xVals.size(); i++) { // index iterates over xVals
      double tmp = 0;
      for (int j = 0; j < simData.size(); j++) { // index iterates over
        // data
        double kernel = gaussianKernel(xVals.get(i) - simData.get(j), bandwidth);
        // double kernel = epanechnikovKernel(xVals.get(i) - simData.get(j), bandwidth);
        tmp += kernel;
      }
      tmp /= simData.size();
      res.add(tmp * 100);
      System.out.println("x:" + xVals.get(i) +", y:" + res.get(i));
    }

    cutoffData.xData = xVals;
    cutoffData.yData = res;

    // for (int i = 0; i < cutoffData.xData.size(); i++) {
    // System.out.println(cutoffData.xData.get(i) + "," +
    // cutoffData.yData.get(i));
    // }

    List<Double> firstDeriv = new ArrayList<Double>();
    List<Double> secondDeriv = new ArrayList<Double>();

    for (int i = 0; i < res.size() - 1; i++) {
      firstDeriv.add((res.get(i + 1) - res.get(i)) / (xVals.get(i + 1) - xVals.get(i)));
    }

    for (int i = 0; i < firstDeriv.size() - 1; i++) {
      secondDeriv.add((firstDeriv.get(i + 1) - firstDeriv.get(i)) / (xVals.get(i + 2) - xVals.get(i + 1)));
    }

    List<Double> changing = new ArrayList<Double>();

    for (int i = 0; i < firstDeriv.size() - 1; i++) {
      changing.add(firstDeriv.get(i) * firstDeriv.get(i + 1));
    }
    changing.add(0.0); // add 0 to end of list for 99th value

    List<Integer> criticalPoints = new ArrayList<Integer>();
    

    
    for (int i = 0; i < changing.size(); i++) {
      if (changing.get(i) <= 0.0) {
    	  criticalPoints.add(i);
      }  
    }

    cutoffData.minCritLoc = new ArrayList<Integer>();
    cutoffData.maxCritLoc = new ArrayList<Integer>();
    cutoffData.infLoc = new ArrayList<Integer>();
    cutoffData.cutoffValues = new ArrayList<Double>();
    for (int i = 0; i < criticalPoints.size(); i++) {
      Integer tmpLoc = criticalPoints.get(i);
      if (tmpLoc < secondDeriv.size()) {
        if (secondDeriv.get(tmpLoc) < 0.0) {
          if (res.get(tmpLoc) > res.get(tmpLoc + 1)) {
            cutoffData.maxCritLoc.add(tmpLoc);
          } else {
            cutoffData.maxCritLoc.add(tmpLoc + 1);
          }
        } else if (secondDeriv.get(tmpLoc) > 0.0) {
          if (res.get(tmpLoc) < res.get(tmpLoc + 1)) {
            cutoffData.minCritLoc.add(tmpLoc);
          } else {
            cutoffData.minCritLoc.add(tmpLoc + 1);
          }
        } else {
          cutoffData.infLoc.add(tmpLoc);
        }
      }
    }
    
    //Check and see if zero is a global max or min.  if so, then include
    boolean zeroMax = true;
    boolean zeroMin = true;
    for (int i=1; i < res.size(); i++) {
    	if (res.get(i) > res.get(0)) zeroMax = false;
    	if (res.get(i) < res.get(0)) zeroMin = false;
    }
    
    if (zeroMax) {
    	cutoffData.maxCritLoc.add(0, 0);
    } else if (zeroMin) {
    	cutoffData.minCritLoc.add(0, 0);
    }
   
    
    //find global max location
    int maxLoc = 0;
    double maxVal = 0.0;
    if (cutoffData.maxCritLoc.size() > 0) {
    	for (int i=0; i<cutoffData.maxCritLoc.size(); i++) {
    		double tmpVal = res.get(cutoffData.maxCritLoc.get(i));
    		if (tmpVal > maxVal){
    			maxLoc = i;
    			maxVal = tmpVal;
    		}
    	}
    }
    
    //now find first local min after global max
    int minLoc = 0;
    boolean found = false;
    if (cutoffData.minCritLoc.size() > 0) {
    	for (int i=0; i<cutoffData.minCritLoc.size(); i++) {
    		if (cutoffData.minCritLoc.get(i) > cutoffData.maxCritLoc.get(maxLoc) && !found) {
    			found = true;
        		minLoc = i;
    		}
    	}
    } else {
    	minLoc = maxLoc;
    }
    

    if (!forceCutoff) {
    	cutoffData.cutoffValues.add(xVals.get(cutoffData.getMinCritLoc().get(minLoc)));
    } else {
    	//bandwidth is zero, so force cutoff to be at data location
    	cutoffData.cutoffValues.add(xVals.get(cutoffData.getMaxCritLoc().get(maxLoc)));
    }

    List<Integer> LUB = new ArrayList<Integer>();

//    if (orthologs) {
//      List<Integer> tmpLoc1 = new ArrayList<Integer>();
//      for (int i = 0; i < cutoffData.minCritLoc.size(); i++) {
//        tmpLoc1.clear();
//        Integer minPoint = cutoffData.minCritLoc.get(i);
//        for (int j = 0; j < simData.size(); j++) {
//          if (simData.get(j) >= xVals.get(minPoint) && orthoData.get(j).equals("Y")) {
//            tmpLoc1.add(j);
//          }
//        }
//
//        if (tmpLoc1.size() > 0) {
//          // This gets the max value (index location) because data is
//          // arranged from largest to smallest
//          // so, this results in getting the value greater than but
//          // closest to the xVal that is also an ortholog
//          int loc = Collections.max(tmpLoc1);
//          if (!LUB.contains(loc)) {
//            LUB.add(Collections.max(tmpLoc1));
//          }
//        }
//      }
//      for (int i = 0; i < LUB.size(); i++) {
//        cutoffData.cutoffValues.add(simData.get(LUB.get(i)));
//      }
//
//    } else {
//      System.out.println("Calculating cutoffs without orthologs");
//      for (int i = 0; i < cutoffData.minCritLoc.size(); i++) {
//        Integer minPoint = cutoffData.minCritLoc.get(i);
//        cutoffData.cutoffValues.add(xVals.get(minPoint));
//      }
//    }
//
//    if (cutoffData.cutoffValues.size() == 0) {
//      System.out.println("No cutoff values found, probably due to no orthologs after minimum");
//      System.out.println("setting cutoff value to 100");
//      cutoffData.cutoffValues.add(100.0);
//    }

    System.out.println("finished cutoff calculations");
    return cutoffData;
  }

  /***
   * Calculates the interquartile range
   * 
   * @param values
   *          - array of doubles
   * @return interquartile range
   */
  private double iqr(double[] values) {

    if (values == null || values.length == 0) {
      throw new IllegalArgumentException("The data array is invalid");
    }

    double[] v = new double[values.length];
    System.arraycopy(values, 0, v, 0, values.length);
    Arrays.sort(v);

    int n75 = (int) Math.round((v.length - 1) * 75.0 / 100);
    int n25 = (int) Math.round((v.length - 1) * 25.0 / 100);

    return v[n75] - v[n25];
  }

  /***
   * Gaussian kernel calculation
   * 
   * @param u
   *          - euclidean difference between data points (point where kernel is calculated - data point)
   * @param scale
   *          - bandwidth
   * @return
   */
  @SuppressWarnings("unused")
  private double gaussianKernel(double u, double scale) {

    double kernel = 1 / Math.sqrt(2 * Math.PI * scale) * Math.exp(-0.5 * u * u / scale);
    return kernel;
  }

  /***
   * Epanechnikov kernel calculation
   * 
   * @param u
   *          - euclidean difference between data points (point where kernel is calculated - data point)
   * @param scale
   *          - bandwidth
   * @return
   */
  @SuppressWarnings("unused")
  private double epanechnikovKernel(double u, double scale) {

    double kernel = 0.0;
    u /= scale;
    if (Math.abs(u) <= 1.0) {
      kernel = 0.75 * (1 - u * u) / scale;
    }
    return kernel;
  }

  /**
   * @return DensityModel - LineChartModel object containing cutoff graph
   */
  public LineChartModel genDensityModel() {

    List<Double> xDataTemp = CutoffData.this.getxData();
    List<Double> xData = new ArrayList<Double>();
    for (Double xVal : xDataTemp) {
      xData.add(xVal);
    }
    List<Double> yData = CutoffData.this.getyData();
    List<Double> cutoffs = CutoffData.this.getCutoffValues();
    List<Integer> maxLocs = CutoffData.this.getMaxCritLoc();
    List<Integer> minLocs = CutoffData.this.getMinCritLoc();
    List<Integer> infLocs = CutoffData.this.getInfLoc();

    LineChartModel densityModel = new LineChartModel();

    LineChartSeries densitySeries = new LineChartSeries();
    for (int i = 0; i < xData.size(); i++) {
      densitySeries.set(xData.get(i), yData.get(i));
    }
    densitySeries.setShowLine(true);
    densitySeries.setShowMarker(false);
    densitySeries.setLabel("Density");

    LineChartSeries maxSeries = new LineChartSeries();
    for (int i = 0; i < maxLocs.size(); i++) {
      maxSeries.set(xData.get(maxLocs.get(i)), yData.get(maxLocs.get(i)));
    }
    maxSeries.setShowLine(false);
    maxSeries.setShowMarker(true);
    maxSeries.setLabel("Local Max");

    LineChartSeries minSeries = new LineChartSeries();
    for (int i = 0; i < minLocs.size(); i++) {
      minSeries.set(xData.get(minLocs.get(i)), yData.get(minLocs.get(i)));
    }
    minSeries.setShowLine(false);
    minSeries.setShowMarker(true);
    minSeries.setLabel("Local Min");

    LineChartSeries infSeries = new LineChartSeries();
    for (int i = 0; i < infLocs.size(); i++) {
      infSeries.set(xData.get(infLocs.get(i)), yData.get(infLocs.get(i)));
    }
    infSeries.setShowLine(false);
    infSeries.setShowMarker(true);
    infSeries.setLabel("Inflection Point");

    densityModel.addSeries(densitySeries);
    densityModel.addSeries(maxSeries);
    densityModel.addSeries(minSeries);
    densityModel.addSeries(infSeries);
    densityModel.setTitle("Cut-off Based on Ortholog Candidates");
    densityModel.setLegendPosition("ne");
    Axis xAxis = densityModel.getAxis(AxisType.X);
    xAxis.setLabel("Percent Similarity");
    xAxis.setTickCount(11);
    xAxis.setMin(0);
    xAxis.setMax(100);
    xAxis.setTickAngle(-50);
    Axis yAxis = densityModel.getAxis(AxisType.Y);
    yAxis.setLabel("Density");
    yAxis.setMin(0);

    return densityModel;
  }
  
  public LineChartModel genL4DensityModel() {

	    List<Double> xDataTemp = CutoffData.this.getxData();
	    List<Double> xData = new ArrayList<Double>();
	    for (Double xVal : xDataTemp) {
	      xData.add(xVal);
	    }
	    List<Double> yData = CutoffData.this.getyData();
	    List<Double> cutoffs = CutoffData.this.getCutoffValues();
	    List<Integer> maxLocs = CutoffData.this.getMaxCritLoc();
	    List<Integer> minLocs = CutoffData.this.getMinCritLoc();
	    List<Integer> infLocs = CutoffData.this.getInfLoc();

	    LineChartModel densityModel = new LineChartModel();

	    LineChartSeries densitySeries = new LineChartSeries();
	    for (int i = 0; i < xData.size(); i++) {
	      densitySeries.set(xData.get(i), yData.get(i));
	    }
	    densitySeries.setShowLine(true);
	    densitySeries.setShowMarker(false);
	    densitySeries.setLabel("Density");

	    LineChartSeries maxSeries = new LineChartSeries();
	    for (int i = 0; i < maxLocs.size(); i++) {
	      maxSeries.set(xData.get(maxLocs.get(i)), yData.get(maxLocs.get(i)));
	    }
	    maxSeries.setShowLine(false);
	    maxSeries.setShowMarker(true);
	    maxSeries.setLabel("Local Max");

	    LineChartSeries minSeries = new LineChartSeries();
	    for (int i = 0; i < minLocs.size(); i++) {
	      minSeries.set(xData.get(minLocs.get(i)), yData.get(minLocs.get(i)));
	    }
	    minSeries.setShowLine(false);
	    minSeries.setShowMarker(true);
	    minSeries.setLabel("Local Min");

	    LineChartSeries infSeries = new LineChartSeries();
	    for (int i = 0; i < infLocs.size(); i++) {
	      infSeries.set(xData.get(infLocs.get(i)), yData.get(infLocs.get(i)));
	    }
	    infSeries.setShowLine(false);
	    infSeries.setShowMarker(true);
	    infSeries.setLabel("Inflection Point");

	    densityModel.addSeries(densitySeries);
	    densityModel.addSeries(maxSeries);
	    densityModel.addSeries(minSeries);
	    densityModel.addSeries(infSeries);
	    densityModel.setTitle("Cut-off Based on Ortholog Candidates");
	    densityModel.setLegendPosition("ne");
	    Axis xAxis = densityModel.getAxis(AxisType.X);
	    xAxis.setLabel("Absolute Length");
	    xAxis.setTickCount(11);
	    xAxis.setMin(0);
	    xAxis.setMax(100);
	    xAxis.setTickAngle(-50);
	    Axis yAxis = densityModel.getAxis(AxisType.Y);
	    yAxis.setLabel("Density");
	    yAxis.setMin(0);
	    
	    densityModel.setLegendPosition("e");
	    densityModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
	    

	    return densityModel;
	  }


  /**
   * @return ChartPanel object containing cutoff graph
   */
  public ChartPanel genCutoffChart(int level) {

    XYSeries pngSeries = new XYSeries("Density Data");
    for (int i = 0; i < CutoffData.this.xData.size(); i++) {
      pngSeries.add(CutoffData.this.xData.get(i), CutoffData.this.yData.get(i));
    }
    XYSeriesCollection pngData = new XYSeriesCollection(pngSeries);
    String xLabel = null;
    String yLabel = "Density";
    if (level == 4) {
    	xLabel = "Abs value of length difference vs. query (%)";
    } else {
    	xLabel = "Percent Similarity";
    }
    
    JFreeChart pngChart = ChartFactory.createXYLineChart("", xLabel, yLabel, pngData,
        PlotOrientation.VERTICAL, true, true, false);
    pngChart.removeLegend();
    XYPlot plot = (XYPlot) pngChart.getPlot();
    ValueAxis xAxis2 = plot.getDomainAxis();
    xAxis2.setRange(0, 100);

    ChartPanel chartPanel = new ChartPanel(pngChart);
    // chartPanel.setSize(560, 367);

    return chartPanel;
  }

  // Getters and Setters

  public List<Double> getxData() {
    return xData;
  }

  public void setxData(List<Double> xData) {
    this.xData = xData;
  }

  public List<Double> getyData() {
    return yData;
  }

  public void setyData(List<Double> yData) {
    this.yData = yData;
  }

  public List<Double> getCutoffValues() {
    return cutoffValues;
  }

  public void setCutoffValues(List<Double> cutoffValues) {
    this.cutoffValues = cutoffValues;
  }

  public List<Integer> getMaxCritLoc() {
    return maxCritLoc;
  }

  public void setMaxCritLoc(List<Integer> maxCritLoc) {
    this.maxCritLoc = maxCritLoc;
  }

  public List<Integer> getMinCritLoc() {
    return minCritLoc;
  }

  public void setMinCritLoc(List<Integer> minCritLoc) {
    this.minCritLoc = minCritLoc;
  }

  public List<Integer> getInfLoc() {
    return infLoc;
  }

  public void setInfLoc(List<Integer> infLoc) {
    this.infLoc = infLoc;
  }

}
