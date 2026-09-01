window.api = axios.create({
	baseURL: "http://192.168.137.1:4242",
	validateStatus: () => true
});