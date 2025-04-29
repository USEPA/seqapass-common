# Sequence Alignment to Predict Across Species Susceptibility (SeqAPASS)

<table>
<tbody>
<tr>
    <td>Documentation</td><td>

[![Docs Badge](https://img.shields.io/badge/User-Guide-blue)](https://www.epa.gov/system/files/documents/2024-09/seqapassv8.0-user-guide.pdf) 
    </td>
</tr>
<tr>
    <td>Website</td><td>

[![Site Badge](https://img.shields.io/badge/SeqAPASS-Application-blue)](https://seqapass.epa.gov/seqapass) 
    </td>
</tr>

</tbody>
</table>

## Overview
The US Environmental Protection Agency’s Sequence Alignment to Predict Across Species Susceptibility (SeqAPASS) tool computationally evaluates similarity of species at the level of the protein, using evidence of conservation to predict potential susceptibility to chemicals. Four levels of evaluation have been developed allowing for increasingly detailed protein sequence and structural comparisons that can predict species specific differences. Level 1 compares primary amino acid sequences, Level 2 compares functional domains, and Level 3 compares critical individual amino acids across species. The Level 4 evaluation is intended for advanced users only and generates protein structural models to perform structural alignments for an additional line of evidence of conservation. Such results can also be exported for more advanced bioinformatics approaches like molecular docking, virtual screening, or molecular dynamic simulations. Each level provides an additional line of evidence toward conservation and a prediction of susceptibility, which is equivalent to saying the protein is conserved in that species and the chemical is likely to interact similar to the query species. Users will choose to run Level 2, Level 3, and Level 4 if there is enough knowledge available relative to functional domains, critical amino acids and solved chemical-protein structures.

## Why use SeqAPASS?
Such analyses have been used for decision-making within the Agency and to support chemical prioritization, selection of appropriate toxicity test organisms, extrapolation of empirical toxicity data, predictions of bioaccumulation potential, and/or assessment of pathway conservation. Commonly, data from the tool is generated for application in chemical safety assessments.

## How to get started
### Application
Visit the SeqAPASS [User Guide](https://www.epa.gov/system/files/documents/2024-09/seqapassv8.0-user-guide.pdf).
### Developers
SeqAPASS is comprised of 4 main components: 
<ul>
  <li>front end (<a href="https://github.com/USEPA/seqapass_frontend/">GitHub repo</a>)</li>
  <li>back end (<a href="https://github.com/USEPA/seqapass_backend/">GitHub repo</a>)</li>
  <li>common library (<a href="https://github.com/USEPA/seqapass_common/">GitHub repo</a>)</li>
  <li>database</li>
</ul>
The front end and back end codes use [Apache Maven](https://maven.apache.org/) to assist with 3rd party library management.  Both the front end and back end use the common code library for compilation.
SeqAPASS database schema information is coming soon.

## Need help?
Please feel free to reach out to the SeqAPASS team with any questions or to request training at [SeqAPASS Support](mailto:seqapass.support@epa.gov). You may also reach out directly to the Product Owner: <LaLone.Carlie@epa.gov>, <clalone@d.umn.edu>, or <carlie.lalone@yahoo.com>
