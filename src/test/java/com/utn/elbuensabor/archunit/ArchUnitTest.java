package com.utn.elbuensabor.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

@AnalyzeClasses(packages = "com.utn.elbuensabor", importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchUnitTest {
}
