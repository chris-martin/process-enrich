process-enrich
==============

Adds functionality to `scala.sys.process.ProcessBuilder`.

Example usage
--------------

```scala
import org.codeswarm.processenrich.RichProcessBuilder.apply

// Run command "ls /nonexistantfilepath"
val x = Seq("ls", "/nonexistantfilepath").stringOutput

// Prints:
//   Out: [  ]
//   Err: [ ls: cannot access /nonexistantfilepath: No such file or directory ]
print("Out: [ %s ]\nErr: [ %s ]".format(x.out.trim, x.err.trim))
```

Download
--------

Process-enrich is available from Maven Central.
The latest version is 1.0.

```xml
<dependency>
  <groupId>org.codeswarm</groupId>
  <artifactId>process-enrich_2.9.2</artifactId>
  <version>1.0</version>
</dependency>
```

