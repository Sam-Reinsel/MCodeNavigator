MProjectNavigator
=====================

MProjectNavigator is a tool for viewing a Matlab project's source tree.

This is intended for use within the Matlab desktop IDE.

## Caution: Undocumented Features!

This program makes extensive use of undocumented, unsupported Matlab features. Use at your own risk, do not use in production code, and use caution when using its source code as an example.

## Requirements

Requires Matlab.

This program is developed and tested on Matlab R2016b and R2017b. It may work on other versions as well. I don't intend to support releases prior to R2016b if there are any significant differences, though.

I use this primarily on Mac, but it should work on all OSes that Matlab runs on. If you find an issue on another OS, feel free to [report it as a bug](https://github.com/apjanke/MProjectNavigator/issues).

## Installation

* Download the distribution and unzip it (or clone the repo from GitHub)
* Add this to your `startup.m` file:
```
cd </path/to/unzipped/distribution>/MProjectNavigatory/bootstrap
loadMProjectNavigator
```

Alternately, if you don't want to modify your `startup.m` file, you can just run `loadMProjectNavigator` each time you want to use the tool. That function takes care of adding all the paths and other initialization. See it for details.

## Author

MProjectNavigator is written by <a href="https://apjanke.net">Andrew Janke</a>. Source code is available in the <a href="https://github.com/apjanke/MProjectNavigator">MProjectNavigator repo on GitHub</a>.

Bug reports, feedback, and minor bug fix PRs are welcome. Please ask first (by [submitting an issue](https://github.com/apjanke/MProjectNavigator/issues)) before doing PRs for new features or behavior changes. This is a personal project, and I'm finicky about its behavior, so I wouldn't want you to waste time writing code that won't be accepted.

## Acknowledgments

I learned how to do the Matlab/Java tree programming from Yair Altman's <a href="https://www.mathworks.com/matlabcentral/fileexchange/14317-findjobj-find-java-handles-of-matlab-graphic-objects">findjobj</a> tool, and articles on his <a href="https://undocumentedmatlab.com/">Undocumented Matlab</a> site.

## License

MProjectNavigator is licensed under the 3-Clause BSD License.

This program uses icons from the <a href="http://www.famfamfam.com/lab/icons/silk/">Silk icon set</a> by Mark James. They are licensed under the <a href="https://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a>.

## Bugs

I think I have a memory leak somewhere. I occasionally get a Java out of memory error when I've been running it for a while. (Though this usually happens when I've viewed large trees, like the MATLAB class definitions in flat package view.)
