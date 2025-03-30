@import dev.slapps.jte.RootController.RootModel

@param RootModel model

<h1>JTE Demo</h1>
<p>This is a demo template written with JTE!</p>
Model: <pre>${model.toString()}</pre>
Blah: ${model.blah()}

@template.includes.x("7")
@template.includes.x("fek")