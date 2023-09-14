function downloadIso(version) {
    fetch("/downloads/" + version, {
        method: "GET"
    })

    const a = document.createElement("a");
    a.href = 'obision-' + version + '.iso'
    a.download = "obision-" + version + ".iso";
    a.click();
}
