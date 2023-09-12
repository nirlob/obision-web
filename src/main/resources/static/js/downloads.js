function download(version) {
    fetch("/downloads/" + version, {
        method: "GET"
    })
    .then(response => response.blob())
    .then(data => {
        const a = document.createElement("a");
        a.href = window.URL.createObjectURL(data);
        a.download = "obision-" + version + ".iso";
        a.click();
    });
}
